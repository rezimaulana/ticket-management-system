package com.lawencon.ticketms.repository.jpql;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.model.User;

@Repository
public interface UserRepositoryJpql extends JpaRepository<User, Long>{
	int removeById(Long id);
	@Query(" SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "LEFT JOIN FETCH u.company c "
				+ "LEFT JOIN FETCH u.picId pic "
				+ "WHERE u.email = :email")
	Optional<User> getByEmail(@Param("email") String email);
	@Query("SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "LEFT JOIN FETCH u.company c "
				+ "LEFT JOIN FETCH u.picId pic "
				+ "LEFT JOIN FETCH u.file f "
				+ "WHERE r.roleCode = :roleCode ")
	List<User> getAllIdCust(@Param("roleCode") String roleCode);
	@Query("SELECT u "
				+ "FROM User u "
				+ "INNER JOIN FETCH u.role r "
				+ "WHERE r.roleCode = :roleCode ")
	List<User> getAllIdPic(@Param("roleCode") String roleCode);
	@Query( "SELECT u "
			+ "FROM User u "
			+ "INNER JOIN FETCH u.role r "
			+ "LEFT JOIN FETCH u.company c "
			+ "LEFT JOIN FETCH u.picId pic "
			+ "LEFT JOIN FETCH u.file f "
			+ "WHERE pic.id = :id ")
	List<User> getAllIdPicIdCust(long id);
}
