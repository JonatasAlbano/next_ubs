package br.com.nextubs.api.v1.findubs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ubs")
public class Ubs {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double vlrLatitude;
	private Double vlrLongitude;
	private Integer codMunic;
	private Integer codCnes;
	private String nomEstab;
	private String dscEndereco;
	private String dscBairro;
	private String dscCidade;
	private String dscTelefone;
	private String dscEstrutFisicAmbiencia;
	private String dscAdapDeficFisicIdosos;
	private String dscEquipamentos;
	private String dscMedicamentos;
}
