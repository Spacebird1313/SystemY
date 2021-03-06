package be.uantwerpen.systemY.shared;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

/**
 * Node class holds the hostname and ip address of a node.
 */
@XmlRootElement(name = "Node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Node implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String hostname;
	private String ipAddress;
	
	/**
	 * Creates a node Object with arguments set to null.
	 */
	public Node()
	{
		this.hostname = null;
		this.ipAddress = null;
	}
	
	/**
	 * Creates a node Object.
	 * 
	 * @param hostname	Hostname of the node.
	 * @param ipAddress	Ip address of the node.
	 */
	public Node(String hostname, String ipAddress)
	{
		this.hostname = hostname;
		this.ipAddress = ipAddress;
	}
	
	/**
	 * Sets the hostname of the node.
	 * 
	 * @param hostname	New hostname of the node.
	 */
	public void setHostname(String hostname)
	{
		this.hostname = hostname;
	}
	
	/**
	 * Sets the ip address of the node.
	 * 
	 * @param ipAddress	New ip of the node.
	 */
	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}
	
	/**
	 * Returns the hostname of this node.
	 * 
	 * @return The hostname of the node.
	 */
	public String getHostname()
	{
		return this.hostname;
	}
	
	/**
	 * Returns the ip address of this node.
	 * 
	 * @return The ip address of the node.
	 */
	public String getIpAddress()
	{
		return this.ipAddress;
	}
	
	/**
	 * Calculates the hash of the hostname.
	 * 
	 * @return The calculated hash value.
	 */
	public int getHash()
	{
		return new HashFunction().getHash(hostname);
	}
	
	/**
	 * Makes a comparison between two nodes.
	 * @param object	The object which will be compared to the node.
	 * @return	True if the given object is the same as the executing node.
	 */
	@Override
	public boolean equals(Object object)
	{
		if(object == null)
		{
			return false;
		}
		if(object == this)
		{
			return true;
		}
		if(!(object instanceof Node))
		{
			return false;
		}
		Node aNode = (Node)object;
		if(aNode.getHostname().equals(this.hostname) && aNode.getIpAddress().equals(this.ipAddress))
		{
			return true;
		}
		return false;
	}
}
