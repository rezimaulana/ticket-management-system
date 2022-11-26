package com.lawencon.ticketms.dao.impl.hibernate.hql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.constant.RoleConst;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.model.User;

@Repository
@Profile("hql")
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
		final User result = this.em.find(User.class, id);
		em.detach(result);
		final Optional<User> userOptional = Optional.ofNullable(result);
		return userOptional;
	}

	@Override
	public List<User> getAll()  {
		final String sql = " SELECT u "
				+ "	FROM User u ";
		final List<User> result = this.em.createQuery(sql, User.class).getResultList();
		return result;
	}

	@Override
	public boolean deleteById(final Long id)  {
		final String sql = " DELETE FROM User WHERE id = :id ";
		final int result = this.em.createQuery(sql)
				.setParameter("id", id)
				.executeUpdate();
		return result > 0;
	}

	@Override
	public Optional<User> getByEmail(final String email)  {		
		final String sql = " SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "LEFT JOIN FETCH u.company c "
				+ "LEFT JOIN FETCH u.picId pic "
				+ "WHERE u.email = :email";
		final User result = this.em.createQuery(sql, User.class).setParameter("email", email).getSingleResult();
		final Optional<User> userOptional = Optional.ofNullable(result);
		return userOptional;
	}

	@Override
	public List<User> getAllIdCust() {
		final String sql = "SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "LEFT JOIN FETCH u.company c "
				+ "LEFT JOIN FETCH u.picId pic "
				+ "LEFT JOIN FETCH u.file f "
				+ "WHERE r.roleCode = :roleCode ";
		final List<User> result = this.em.createQuery(sql, User.class)
				.setParameter("roleCode", RoleConst.CUST.getRoleCodeEnum()).getResultList();
		return result;
	}

	@Override
	public List<User> getAllIdPic() {
		final String sql = "SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "WHERE r.roleCode = :roleCode ";
		final List<User> result = this.em.createQuery(sql, User.class)
				.setParameter("roleCode", RoleConst.PIC.getRoleCodeEnum()).getResultList();
		return result;
	}
	
	@Override
	public 	List<User> getAllIdPicIdCust(long id) {
		final String sql = "SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "LEFT JOIN FETCH u.company c "
				+ "LEFT JOIN FETCH u.picId pic "
				+ "LEFT JOIN FETCH u.file f "
				+ "WHERE pic.id = :id ";
		final List<User> result = this.em.createQuery(sql, User.class)
				.setParameter("id", id).getResultList();
		return result;
	}

}
