package com.karyawan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long karyawanId;
    private String karyawanName;
    private String karyawanAddress;
    private String karyawanPhoneNumber;
}
