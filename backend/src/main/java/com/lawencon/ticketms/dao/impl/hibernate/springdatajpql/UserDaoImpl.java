package com.lawencon.ticketms.dao.impl.hibernate.springdatajpql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketms.constant.RoleConst;
import com.lawencon.ticketms.dao.UserDao;
import com.lawencon.ticketms.model.User;
import com.lawencon.ticketms.repository.jpql.UserRepositoryJpql;

@Repository
@Profile("datajpql")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{
	
	@Autowired
	private UserRepositoryJpql repository;
	
	@Override
	public User insert(final User data)  {
		return repository.save(data);
	}

	@Override
	public User update(final User data)  {
		return repository.saveAndFlush(data);
	}

	@Override
	public Optional<User> getById(final Long id)  {
		return repository.findById(id);
	}

	@Override
	public List<User> getAll()  {
		return repository.findAll();
	}

	@Override
	public boolean deleteById(final Long id)  {
		final int result = repository.removeById(id);
		return result > 0;
	}

	@Override
	public Optional<User> getByEmail(final String email)  {		
		final User result = repository.getByEmail(email).get();
		em.detach(result);
		return Optional.ofNullable(result);
	}

	@Override
	public List<User> getAllIdCust() {
		return repository.getAllIdCust(RoleConst.CUST.getRoleCodeEnum());
	}

	@Override
	public List<User> getAllIdPic() {
		return repository.getAllIdPic(RoleConst.PIC.getRoleCodeEnum());
	}
	
	@Override
	public 	List<User> getAllIdPicIdCust(long id) {
		return repository.getAllIdPicIdCust(id);
	}

}
