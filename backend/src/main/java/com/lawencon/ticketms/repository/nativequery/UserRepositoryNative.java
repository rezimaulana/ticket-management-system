package com.lawencon.ticketms.repository.nativequery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.User;

@Repository
public interface UserRepositoryNative extends JpaRepository<User, Long>{
	int removeById(Long id);
	@Query(value= " SELECT * "
			+ "FROM users u "
			+ "INNER JOIN roles r ON r.id = u.role_id "
			+ "WHERE u.email = :email",nativeQuery=true)
	User getByEmail(@Param("email") String email);
	@Query(value="SELECT u.id AS id, u.email AS email, u.fullname AS fullname, "
				+ "u.pic_id AS pic_id, pic.email AS pic_email, pic.fullname AS pic_name, "
				+ "u.company_id AS c_id, c.company_code AS c_company_code, c.company_name AS c_name, "
				+ "u.role_id AS r_id , r.role_code AS r_code, r.role_name AS r_name, "
				+ "f.id AS f_id, f.file_code AS f_code, f.file_ext AS f_ext, u.ver AS u_ver "
				+ "FROM users u "
				+ "INNER JOIN roles r ON r.id = u.role_id "
				+ "LEFT JOIN companies c ON c.id = u.company_id "
				+ "LEFT JOIN users pic ON pic.id = u.pic_id "
				+ "LEFT JOIN files f on f.id = u.photo_id "
				+ "WHERE r.role_code = :role_code ", nativeQuery=true)
	List<Object[]> getAllIdCust(@Param("role_code") String code);
	@Query(value="SELECT u.id AS id, u.email AS email, u.fullname AS fullname, "
				+ "r.id AS r_id, r.role_code AS r_code, r.role_name AS r_name "
				+ "FROM users u "
				+ "INNER JOIN roles r ON r.id = u.role_id "
				+ "WHERE r.role_code = :role_code ", nativeQuery= true)
	List<Object[]> getAllIdPic(@Param("role_code") String code);
	@Query(value="SELECT u.id AS id, u.email AS email, u.fullname AS fullname, "
				+ "u.pic_id AS pic_id, pic.email AS pic_email, pic.fullname AS pic_name, "
				+ "u.company_id AS c_id, c.company_code AS c_company_code, c.company_name AS c_name, "
				+ "u.role_id AS r_id , r.role_code AS r_code, r.role_name AS r_name, "
				+ "f.id AS f_id, f.file_code AS f_code, f.file_ext AS f_ext, u.ver AS u_ver "
				+ "FROM users u "
				+ "INNER JOIN roles r ON r.id = u.role_id "
				+ "LEFT JOIN companies c ON c.id = u.company_id "
				+ "LEFT JOIN users pic ON pic.id = u.pic_id "
				+ "LEFT JOIN files f on f.id = u.photo_id "
				+ "WHERE u.pic_id = :id ", nativeQuery = true)
	List<Object[]> getAllIdPicIdCust(@Param("id") long id);
}
