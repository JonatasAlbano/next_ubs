package br.com.nextubs.api.v1.findubs.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.nextubs.api.v1.findubs.model.Ubs;

@Repository
public interface UbsRepository extends JpaRepository<Ubs, Long> {
	
	@Query(value = "SELECT * FROM Ubs u ORDER BY (6371 * acos(cos(radians(:lat)) * cos(radians(u.vlr_latitude)) * cos(radians(u.vlr_longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(u.vlr_latitude)))) ASC", nativeQuery = true)
	public List<Ubs> findAllUbsNextAPoint(@Param("lat") double latitude, @Param("lon") double longitude, Pageable pageable);
	
}