package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IMascotaDao;
import com.backend.veterinaria.model.entity.Mascota;
import com.backend.veterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaDao mascotaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Mascota> listarMascotas() {
        return (List<Mascota>) mascotaDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Mascota obtenerMascotaPorId(Integer id) {
        return mascotaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Mascota guardarMascota(Mascota mascota) {
        return mascotaDao.save(mascota);
    }

    @Transactional
    @Override
    public void eliminarMascota(Integer id) {
        mascotaDao.deleteById(id);
    }
}
