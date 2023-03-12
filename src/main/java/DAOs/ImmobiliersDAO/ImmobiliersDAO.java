package dao;

import java.util.List;
import Beans.Immobiliers;


package DAOs.ImmobiliersDAO;
public interface ImmobiliersDAO {
    public void addImmobilier(Immobiliers immobiliers, User user);
    public void updateImmobilier(Immobiliers immobiliers);
    public void deleteImmobilier(Long id);
    public Immobiliers getImmobilierById(Long id);
    public Immobiliers getImmobiliersByUser(Long proprietaireId);
    public List<Immobiliers> getAllImmobilirs();
}
