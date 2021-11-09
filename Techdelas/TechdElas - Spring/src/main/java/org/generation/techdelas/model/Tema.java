package org.generation.techdelas.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table (name = "tb_tema")
public class Tema {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idTema;
		
		
		@NotNull
		@Size(min = 5, max = 40, message = "O número mínimo de caracteres é 5 e o máximo 40.")
		private String nomeTema;
		
		@NotNull
		@Size (min = 10 , max = 300, message = "O número mínimo de caracteres é 10 e o máximo é 300.")
		private String sobre;
		
		@NotNull
		@Size (min = 10, max = 255, message = "O número mínimo de caracteres é 10 e o máximo é 255.")
		private String imgDevs;
		
		public long getIdTema() {
			return idTema;
		}

		public void setIdTema(long idTema) {
			this.idTema = idTema;
		}

		public String getNomeTema() {
			return nomeTema;
		}

		public void setNomeTema(String nomeTema) {
			this.nomeTema = nomeTema;
		}

		public String getSobre() {
			return sobre;
		}

		public void setSobre(String sobre) {
			this.sobre = sobre;
		}

		public String getImgDevs() {
			return imgDevs;
		}

		public void setImgDevs(String imgDevs) {
			this.imgDevs = imgDevs;
		}

		
}		
		