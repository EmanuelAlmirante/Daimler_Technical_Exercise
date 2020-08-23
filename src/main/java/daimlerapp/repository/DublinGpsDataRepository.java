package daimlerapp.repository;

import daimlerapp.model.DublinGpsDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DublinGpsDataRepository extends JpaRepository<DublinGpsDataModel, Long> {
}
