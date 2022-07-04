package com.meiirzhan.twitter.repositories;

import com.meiirzhan.twitter.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BlogRepo extends JpaRepository<BlogEntity, Long> {
    List<BlogEntity> findAllByUserEntityId(long id);

    @Query("select b from blog b where upper(b.title)  like concat('%', upper(:filter), '%') or b.description like concat('%', upper(:filter), '%')or b.userEntity.firstName like concat('%', upper(:filter), '%')or b.userEntity.lastName like concat('%', upper(:filter), '%')or b.userEntity.secondName like concat('%', upper(:filter), '%')or b.userEntity.login like concat('%', upper(:filter), '%')")
    List<BlogEntity> findByFilter(@Param("filter") String filter);
}
