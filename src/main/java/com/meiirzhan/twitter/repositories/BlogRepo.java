package com.meiirzhan.twitter.repositories;

import com.meiirzhan.twitter.Entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepo extends JpaRepository<BlogEntity, Long> {
    java.util.List<BlogEntity> findAllByUserEntityId(long id);

    @Query("select b from blogs b where upper(b.title)  like concat('%', upper(:filter), '%') or b.description like concat('%', upper(:filter), '%')or b.userEntity.firstName like concat('%', upper(:filter), '%')or b.userEntity.lastName like concat('%', upper(:filter), '%')or b.userEntity.secondName like concat('%', upper(:filter), '%')or b.userEntity.login like concat('%', upper(:filter), '%')")
    java.util.List<BlogEntity> findByFilter(@Param("filter") String filter);
}
