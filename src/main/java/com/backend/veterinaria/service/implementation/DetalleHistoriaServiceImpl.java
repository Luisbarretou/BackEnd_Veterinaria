package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IDetalleHistoriaDao;
import com.backend.veterinaria.model.entity.DetalleHistoria;
import com.backend.veterinaria.service.IDetalleHistoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleHistoriaServiceImpl implements IDetalleHistoriaService {

    @Autowired
    private IDetalleHistoriaDao detalleHistoriaDao;

    @Transactional(readOnly = true)
    @Override
    public List<DetalleHistoria> listarDetallesHistoria() {
        return (List<DetalleHistoria>) detalleHistoriaDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public DetalleHistoria obtenerDetalleHistoriaPorId(Integer id) {
        return detalleHistoriaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public DetalleHistoria guardarDetalleHistoria(DetalleHistoria detalleHistoria) {
        return detalleHistoriaDao.save(detalleHistoria);
    }

    @Transactional
    @Override
    public void eliminarDetalleHistoria(Integer id) {
        detalleHistoriaDao.deleteById(id);
    }
}
