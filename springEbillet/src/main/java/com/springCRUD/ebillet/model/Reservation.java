package com.springCRUD.ebillet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="reservations")
public class Reservation implements Serializable {

	public Reservation() {
		super();
	
	}

	public Reservation(Evenements id2, Long user) {
        System.out.print("id evenement"+"-----"+id2);
        this.event = id2;
        System.out.print("id evenement"+"-----"+id2);
        System.out.print("id evenement"+"-----"+id);
        this.isconfirmed = 1;
    
    }
	@Id
	@Column(name="reservation_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Evenements event;
	@ManyToOne
	private User usr;
	private Long idbillet;
	private int isconfirmed;
	private String date;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdbillet() {
		return idbillet;
	}
	public void setIdbillet(Long idbillet) {
		this.idbillet = idbillet;
	}

	public int getIsconfirmed() {
		return isconfirmed;
	}
	public void setIsconfirmed(int isconfirmed) {
		this.isconfirmed = isconfirmed;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
