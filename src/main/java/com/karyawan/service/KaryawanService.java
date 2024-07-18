package com.karyawan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karyawan.model.Karyawan;
import com.karyawan.repository.KaryawanRepository;

import jakarta.transaction.Transactional;

@Service
public class KaryawanService {
    @Autowired
    private KaryawanRepository karyawanRepository;

    @Transactional
    public ResponseEntity<Map<String, Object>> createKaryawan(List<Karyawan> data) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            if (data.isEmpty()) {
                result.put("message ", "Karyawan gagal ditambahkan");
                result.put("statusCode", HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            } else {
                karyawanRepository.saveAll(data);
                result.put("message ", "Karyawan berhasil ditambahkan");
                result.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            result.put("message ", "Karyawan gagal ditambahkan");
            result.put("exception ", e.getCause());
            result.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> readKaryawan() {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            List<Karyawan> data = karyawanRepository.findAll();
            if (data.isEmpty()) {
                result.put("message ", "Karyawan Gagal dibaca");
                result.put("statusCode", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            } else {
                result.put("data", data);
                result.put("message ", "Karyawan berhasil dibaca");
                result.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            result.put("message ", "Karyawan gagal dibaca");
            result.put("exception ", e.getCause());
            result.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<Map<String, Object>> UpdateKaryawan(List<Karyawan> data) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            if (data.isEmpty()) {
                result.put("message ", "Karyawan gagal diperbarui");
                result.put("statusCode", HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
            // Cek validasi id & eksistensi id karyawan di database
            for (Karyawan karyawan : data) {
                if (karyawan.getKaryawanId() == null
                        && karyawanRepository.findById(karyawan.getKaryawanId()).isEmpty()) {
                    result.put("message",
                            "Karyawan ID " + karyawan.getKaryawanId() + " data is missing or karyawan not existed");
                    result.put("statusCode", HttpStatus.BAD_REQUEST.value());
                    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
                }
            }

            karyawanRepository.saveAll(data);
            result.put("message ", "Karyawan berhasil diperbarui");
            result.put("statusCode", HttpStatus.OK.value());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            result.put("message ", "Karyawan gagal diperbarui");
            result.put("exception ", e.getCause());
            result.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public ResponseEntity<Map<String, Object>> deleteKaryawan(List<Long> data) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            if (data.isEmpty()) {
                result.put("message ", "Karyawan gagal dihapus, data yang ingin dihapus tidak ada");
                result.put("statusCode", HttpStatus.BAD_REQUEST.value());
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            } else {
                karyawanRepository.deleteAllById(data);
                result.put("message ", "Karyawan berhasil dihapus");
                result.put("statusCode", HttpStatus.OK.value());
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            result.put("message ", "Karyawan gagal dihapus");
            result.put("exception ", e.getCause());
            result.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
