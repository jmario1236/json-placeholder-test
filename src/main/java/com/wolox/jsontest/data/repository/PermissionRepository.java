package com.wolox.jsontest.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wolox.jsontest.data.entity.PermissionEntity;

public interface PermissionRepository extends CrudRepository<PermissionEntity, Integer>{
	
	PermissionEntity findByIdUserAndIdAlbum(Integer idUser, Integer idAlbum);
	
	@Query("select p.idUser from PermissionEntity p where (p.read = :read or p.write = :write) and p.idAlbum = :idAlbum")
	List<Integer> findByReadAndWriteAndIdAlbum(@Param("read") Boolean read, 
												@Param("write") Boolean write, 
												@Param("idAlbum") Integer idAlbum);	
	
}
