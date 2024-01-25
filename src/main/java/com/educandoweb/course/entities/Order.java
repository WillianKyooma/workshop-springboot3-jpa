package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_order") 
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy, MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User Client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	
	public Order(Long Id, Instant moment,OrderStatus orderStatus,User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		Client = client;
	}
	
	
	// Default no-argument constructor
    public Order() {
    }


	


	


	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	
	

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus !=null) {
		this.orderStatus = orderStatus.GetCode();
		}
	}


	public User getClient() {
		return Client;
	}


	public void setClient(User client) {
		Client = client;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
    
	public Set<OrderItem> getItems(){
		return items;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return id == other.id;
	}
	
	
	
	
}
