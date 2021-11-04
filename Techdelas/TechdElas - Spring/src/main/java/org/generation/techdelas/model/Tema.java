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
		private long id_tema;
		
		@NotNull(message = "Ops! O campo tema NÃO pode ficar nulo")
		@Size(min = 5, max = 40, message = "O número mínimo de caracteres é 5 e o máximo 40.")
		private String nome_tema;
		
		@NotNull(message = "Ops! O campo sobre NÃO pode ficar nulo")
		@Size (min = 10 , max = 300, message = "O número mínimo de caracteres é 10 e o máximo é 300.")
		private String sobre;
		
		@NotNull(message = "Ops! O campo img_devs NÃO pode ficar nulo")
		@Size (min = 10, max = 255, message = "O número mínimo de caracteres é 10 e o máximo é 255.")
		private String img_devs;
		
		
		public long getId_tema() {
			return id_tema;
		}

		public void setId_tema(long id_tema) {
			this.id_tema = id_tema;
		}

		public String getNome_tema() {
			return nome_tema;
		}

		public void setNome_tema(String nome_tema) {
			this.nome_tema = nome_tema;
		}

		public String getSobre() {
			return sobre;
		}

		public void setSobre(String sobre) {
			this.sobre = sobre;
		}

		public String getImg_devs() {
			return img_devs;
		}

		public void setImg_devs(String img_devs) {
			this.img_devs = img_devs;
		}

				
		
	}

