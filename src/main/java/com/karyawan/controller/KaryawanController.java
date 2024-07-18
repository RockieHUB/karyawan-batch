package com.karyawan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karyawan.model.Karyawan;
import com.karyawan.service.KaryawanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/karyawan")
@Slf4j
public class KaryawanController {
    @Autowired
    private KaryawanService karyawanService;

    @PostMapping("/batch-create")
    public ResponseEntity<Map<String, Object>> createKaryawan(@RequestBody List<Karyawan> isi) {
        log.info("Mengakses Create Batch Karyawan");
        ResponseEntity<Map<String, Object>> data = karyawanService.createKaryawan(isi);

        return data;
    }

    @GetMapping("/batch-read")
    public ResponseEntity<Map<String, Object>> readKaryawan() {
        log.info("Mengakses Read Batch Karyawan");
        ResponseEntity<Map<String, Object>> data = karyawanService.readKaryawan();

        return data;
    }

    @PutMapping("/batch-update")
    public ResponseEntity<Map<String, Object>> UpdateKaryawanKaryawan(@RequestBody List<Karyawan> isi) {
        log.info("Mengakses Create Batch Karyawan");
        ResponseEntity<Map<String, Object>> data = karyawanService.UpdateKaryawan(isi);

        return data;
    }

    @DeleteMapping("/batch-delete")
    public ResponseEntity<Map<String, Object>> deleteKaryawan(@RequestBody List<Long> isi) {
        log.info("Mengakses Create Batch Karyawan");
        ResponseEntity<Map<String, Object>> data = karyawanService.deleteKaryawan(isi);

        return data;
    }
}
