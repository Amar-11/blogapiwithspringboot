package com.amar.blogappapis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Getter
@Setter
public class Category {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer categoryId;
		
		private String categoryTitle;
		
		private String categoryDescription;
}
