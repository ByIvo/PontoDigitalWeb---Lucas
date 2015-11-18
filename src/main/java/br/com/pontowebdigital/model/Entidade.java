package br.com.pontowebdigital.model;

import java.io.Serializable;

public abstract class Entidade implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract Integer getId();
	public abstract void setId(Integer id);
	
	public abstract boolean isDeleted();
	public abstract void setDeleted(boolean deleted);

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidade other = (Entidade) obj;
		if (getId() == null)
		{
			if (other.getId() != null)
				return false;
		}
		else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	
	

}
