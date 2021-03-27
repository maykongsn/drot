package br.com.pi.drot.entity;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TratamentoPaciente")
public class TratamentoPaciente{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "paciente_id")
	private int paciente;

	@Column(name = "exame")
	private ArrayList <Exame> exame;

	@Column(name = "remedio")
	private ArrayList <Remedio> remedio;

	@Column(name = "tempoTratamento")
	private Date inicioTratamento;

	@Column(name = "tempoTratamento")
	private Date fimTratamento;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

	public int getPaciente() {
		return this.paciente;
	}

	public ArrayList<Exame> getExame() {
		return exame;
	}

	public void setExame(ArrayList<Exame> exame) {
		this.exame = exame;
	}

	public ArrayList<Remedio> getRemedio() {
		return remedio;
	}

	public void setRemedio(ArrayList<Remedio> remedio) {
		this.remedio = remedio;
	}

	public Date getInicioTratamento() {
		return inicioTratamento;
	}

	public void setInicioTratamento(Date inicioTratamento) {
		this.inicioTratamento = inicioTratamento;
	}

	public Date getFimTratamento() {
		return fimTratamento;
	}

	public void setFimTratamento(Date fimTratamento) {
		this.fimTratamento = fimTratamento;
	}

	public boolean adicionarRemedio(TratamentoPaciente tratamento, Remedio remedio) {
		ArrayList<Remedio> remedios = tratamento.getRemedio();
		remedios.add(remedio);
		tratamento.setRemedio(remedios);
		return true;
	}

	public boolean adicionarExame(TratamentoPaciente tratamento, Exame exame) {
		ArrayList<Exame> exames = tratamento.getExame();
		exames.add(exame);
		tratamento.setExame(exames);
		return true;
	}

	public boolean removerRemedio(TratamentoPaciente tratamento, Remedio remedio) {
		ArrayList<Remedio> remedios = tratamento.getRemedio();
		remedios.remove(remedio);
		tratamento.setRemedio(remedios);
		return true;
	}

	public boolean removerExame(TratamentoPaciente tratamento, Exame exame) {
		ArrayList<Exame> exames = tratamento.getExame();
		exames.remove(exame);
		tratamento.setExame(exames);
		return true;
	}


}