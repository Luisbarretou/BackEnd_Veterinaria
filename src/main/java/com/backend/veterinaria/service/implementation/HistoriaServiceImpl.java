package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IHistoriaDao;
import com.backend.veterinaria.model.entity.Historia;
import com.backend.veterinaria.service.IHistoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoriaServiceImpl implements IHistoriaService {

    @Autowired
    private IHistoriaDao historiaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Historia> listarHistorias() {
        return (List<Historia>) historiaDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Historia obtenerHistoriaPorId(Integer id) {
        return historiaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Historia guardarHistoria(Historia historia) {
        return historiaDao.save(historia);
    }

    @Transactional
    @Override
    public void eliminarHistoria(Integer id) {
        historiaDao.deleteById(id);
    }
}
