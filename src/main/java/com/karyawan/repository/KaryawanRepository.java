package com.karyawan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karyawan.model.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {

}
