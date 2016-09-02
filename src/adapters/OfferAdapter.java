package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.Offer;

public class OfferAdapter {

	public void insert(Offer offer)
	{
		String sql = "INSERT INTO offer VALUES (null,'"+offer.getOfferType()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(Offer offer)
	{
		String sql = "UPDATE offer SET offertitle = '"+offer.getOfferType()+"'' WHERE offerid = '"+offer.getId()+"'";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM offer WHERE offerid="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(Offer offer)
	{
		String sql = "DELETE FROM offer WHERE offerid="+offer.getId();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<Offer> getAll()
	{
		String sql = "SELECT * FROM offer";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Offer> offerlist = new ArrayList<Offer>();
		try {
			while(rs.next())
			{
				Offer offer  = new Offer();
				offer.setId(rs.getInt("offerid"));
				offer.setOfferType(rs.getString("offertype"));
				
				offerlist.add(offer);
			}
			return offerlist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Offer getSingle(int id)
	{
		String sql = "SELECT * FROM area WHERE id="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		Offer offer = new Offer();
		try {
			if(rs.next())
			{
				offer.setId(rs.getInt("offerid"));
				offer.setOfferType(rs.getString("offertype"));
				
				
				return offer;
			}
			else
			{
				return null;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}