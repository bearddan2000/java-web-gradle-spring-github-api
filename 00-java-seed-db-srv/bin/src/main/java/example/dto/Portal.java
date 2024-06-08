package example.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Session;
import example.entity.PortalEntity;

public class Portal
{
  Logger logger = LoggerFactory.getLogger(Portal.class);

  public void insert(PortalEntity entity, Session session) throws Exception {
    String errorMsg = null;

    if (entity == null)
    {
      errorMsg = "must provide entity";
      logger.debug(errorMsg);
      throw new Exception(errorMsg);
    }
    if (session == null)
    {
      errorMsg = "must provide session";
      logger.debug(errorMsg);
      throw new Exception(errorMsg);
    }
    session.beginTransaction();
    session.save(entity);
    session.getTransaction().commit();
  }
}
