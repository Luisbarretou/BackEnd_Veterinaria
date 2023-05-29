package com.backend.veterinaria.service.implementation;

import com.backend.veterinaria.model.dao.IEspecialistaDao;
import com.backend.veterinaria.model.entity.Especialista;
import com.backend.veterinaria.service.IEspecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EspecialistaServiceImpl implements IEspecialistaService {

    @Autowired
    private IEspecialistaDao especialistaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Especialista> listarEspecialistas() {
        return (List<Especialista>) especialistaDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Especialista obtenerEspecialistaPorId(Integer id) {
        return especialistaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Especialista guardarEspecialista(Especialista especialista) {
        return especialistaDao.save(especialista);
    }

    @Transactional
    @Override
    public void eliminarEspecialista(Integer id) {
        especialistaDao.deleteById(id);
    }
}
