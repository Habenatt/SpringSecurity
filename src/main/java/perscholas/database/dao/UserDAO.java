package perscholas.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import perscholas.database.entity.User;
import perscholas.database.entity.UserRole;


public interface UserDAO extends JpaRepository<User,Long> {

    public User findByEmail(@Param("email") String email);

    public List<User> findByLastName(@Param("lastName") String lastName);

    @Query("select u from User u where u.firstName = :firstName and u.lastName = :lastName")
    public List<User> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);

    public List<User> findByFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);


    @Query("select u from User u where u.firstName = :firstName")
    public List<User> findByFirstNameIgnoreCase(String firstName);

    @Query("select u from User u where u.userName = :username")
    public User findByUsername(@Param("username") String userName);

   @Query(value="SELECT u.* FROM user u WHERE u.first_name like '%:firstName%'", nativeQuery = true)
    public List<User> findByFirstNameLike(String firstName);
    @Query("select ur from UserRole ur where ur.user.id = :userId")
    List<UserRole> getUserRoles(Integer userId);

}