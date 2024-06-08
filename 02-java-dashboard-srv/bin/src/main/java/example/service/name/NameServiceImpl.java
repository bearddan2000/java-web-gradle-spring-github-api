package example.service.name;

import example.repository.PortalRepository;
import example.model.Portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameServiceImpl implements NameService {

    @Autowired
    private PortalRepository portalRepository;

    @Override
    public Iterable<Portal> getAll(){
      return portalRepository.findAll();
    }
}
