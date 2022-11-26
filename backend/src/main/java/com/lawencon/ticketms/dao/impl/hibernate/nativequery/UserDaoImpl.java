package com.lawencon.ticketms.dao.impl.hibernate.nativequery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.constant.RoleConst;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.model.Company;
import com.lawencon.ticketms.model.File;
import com.lawencon.ticketms.model.Role;
import com.lawencon.ticketms.model.User;

@Repository
@Profile("native")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{
	
	@Override
	public User insert(final User data)  {
		this.em.persist(data);
		return data;
	}

	@Override
	public User update(final User data)  {
		final User updateOne = this.em.merge(data);
		this.em.flush();
		return updateOne;
	}

	@Override
	public Optional<User> getById(final Long id)  {
		final User user = this.em.find(User.class, id);
		em.detach(user);
		final Optional<User> userOptional = Optional.ofNullable(user);
		return userOptional;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll()  {
		final String sql = " SELECT * "
				+ "	FROM users u ";
		final List<User> users = this.em.createNativeQuery(sql, User.class).getResultList();
		return users;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM users WHERE id = :id ";
		final int result = this.em.createNativeQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public Optional<User> getByEmail(final String email)  {		
		final String sql = " SELECT u.id as lid, u.email AS lemail, u.fullname AS lname, u.pic_id AS p_id, "
				+ "u.company_id AS lcom, r.role_code AS lcode, r.role_name AS lrole, u.password AS upass "
				+ "FROM users u "
				+ "INNER JOIN roles r ON r.id = u.role_id "
				+ "WHERE u.email = :email";
		User user = null;
		Role role = null;
		Company company = null;
		User pic = null;
		try {			
			final Object userObj = this.em.createNativeQuery(sql)
					.setParameter("email", email)
					.getSingleResult();
			if(userObj !=null) {
				Object[] objArr = (Object[]) userObj;
				user = new User();
				role = new Role();
				company = new Company();
				pic = new User();
				user.setId(Long.valueOf(objArr[0].toString()));
				user.setEmail(objArr[1].toString());
				user.setFullname(objArr[2].toString());
				user.setPassword(objArr[7].toString());
				if(objArr[3] != null) {
					pic.setId(Long.valueOf(objArr[3].toString()));
					user.setPicId(pic);	
				}
				if(objArr[4] != null) {
					company.setId(Long.valueOf(objArr[4].toString()));
					user.setCompany(company);
				}
				role.setRoleCode(objArr[5].toString());
				role.setRoleName(objArr[6].toString());
				user.setRole(role);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		final Optional<User> userOptional = Optional.ofNullable(user);
		return userOptional;
	}

	@Override
	public List<User> getAllIdCust()  {
		final String sql = "SELECT u.id AS id, u.email AS email, u.fullname AS fullname, "
				+ "u.pic_id AS pic_id, pic.email AS pic_email, pic.fullname AS pic_name, "
				+ "u.company_id AS c_id, c.company_code AS c_company_code, c.company_name AS c_name, "
				+ "u.role_id AS r_id , r.role_code AS r_code, r.role_name AS r_name, "
				+ "f.id AS f_id, f.file_code AS f_code, f.file_ext AS f_ext, u.ver AS u_ver "
				+ "FROM users u "
				+ "INNER JOIN roles r ON r.id = u.role_id "
				+ "LEFT JOIN companies c ON c.id = u.company_id "
				+ "LEFT JOIN users pic ON pic.id = u.pic_id "
				+ "LEFT JOIN files f on f.id = u.photo_id "
				+ "WHERE r.role_code = :role_code ";
		final List<?> result = this.em.createNativeQuery(sql)
				.setParameter("role_code", RoleConst.CUST.getRoleCodeEnum()).getResultList();
		final List<User> users =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(userObj -> {
				Object[] objArr = (Object[]) userObj;
				final User user = new User();
				user.setId(Long.valueOf(objArr[0].toString()));
				user.setEmail(objArr[1].toString());
				user.setFullname(objArr[2].toString());
				user.setVer(Integer.valueOf(objArr[15].toString()));
				final User pic = new User();
				pic.setId(Long.valueOf(objArr[3].toString()));
				pic.setEmail(objArr[4].toString());
				pic.setFullname(objArr[5].toString());
				user.setPicId(pic);
				final Company company = new Company();
				company.setId(Long.valueOf(objArr[6].toString()));
				company.setCompanyCode(objArr[7].toString());
				company.setCompanyName(objArr[8].toString());
				user.setCompany(company);
				final Role role = new Role();
				role.setId(Long.valueOf(objArr[9].toString()));
				role.setRoleCode(objArr[10].toString());
				role.setRoleName(objArr[11].toString());
				user.setRole(role);
				if(objArr[12] != null) {
					final File file = new File();
					file.setId(Long.valueOf(objArr[12].toString()));
					file.setFileCode(objArr[13].toString());
					file.setFileExt(objArr[14].toString());
					user.setFile(file);
				}
				users.add(user);
			});
		}
		return users;
	}

	@Override
	public List<User> getAllIdPic() {
		final String sql = "SELECT u.id AS id, u.email AS email, u.fullname AS fullname, "
				+ "r.id AS r_id, r.role_code AS r_code, r.role_name AS r_name "
				+ "FROM users u "
				+ "INNER JOIN roles r ON r.id = u.role_id "
				+ "WHERE r.role_code = :role_code ";
		final List<?> result = this.em.createNativeQuery(sql)
				.setParameter("role_code", RoleConst.PIC.getRoleCodeEnum()).getResultList();
		final List<User> users =  new ArrayList<>();
		if(result != null && result.size() > 0) {
			result.forEach(userObj -> {
				Object[] objArr = (Object[]) userObj;
				final User user = new User();
				user.setId(Long.valueOf(objArr[0].toString()));
				user.setEmail(objArr[1].toString());
				user.setFullname(objArr[2].toString());
				final Role role = new Role();
				role.setId(Long.valueOf(objArr[3].toString()));
				role.setRoleCode(objArr[4].toString());
				role.setRoleName(objArr[5].toString());
				user.setRole(role);
				users.add(user);
			});
		}
		return users;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public 	List<User> getAllIdPicIdCust(long id) {
		final String sql = "SELECT * "
				+ "FROM users u "
				+ "INNER JOIN roles r ON r.id = u.role_id "
				+ "LEFT JOIN companies c ON c.id = u.company_id "
				+ "LEFT JOIN users pic ON pic.id = u.pic_id "
				+ "LEFT JOIN files f on f.id = u.photo_id "
				+ "WHERE u.pic_id = :id ";
		final List<User> result = this.em.createNativeQuery(sql, User.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}
