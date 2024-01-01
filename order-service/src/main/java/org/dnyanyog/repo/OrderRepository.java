package org.dnyanyog.repo;

import org.dnyanyog.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
