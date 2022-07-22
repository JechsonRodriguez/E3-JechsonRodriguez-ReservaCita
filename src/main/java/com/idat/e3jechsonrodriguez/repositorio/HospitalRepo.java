package com.idat.e3jechsonrodriguez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.e3jechsonrodriguez.modelo.hospital;

@Repository
public interface HospitalRepo extends JpaRepository<hospital, Integer> {

}
