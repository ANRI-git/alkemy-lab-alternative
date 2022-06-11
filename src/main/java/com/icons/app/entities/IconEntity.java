package com.icons.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String image;
	private String denomination;
	@Column(name = "creation_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate creationDate;
	private Long height;
	private String history;
	@ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
	private List<CountryEntity> countries = new ArrayList<>();

	public void addCountry(CountryEntity country) {
		this.countries.add(country);
	}

	public void removeCountry(CountryEntity country) {
		this.countries.remove(country);
	}

}
