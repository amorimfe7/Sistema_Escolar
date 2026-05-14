package model;

public class Turma {
    private int id;
    private int instituicao_id;
    private int professor_id;
    private String nome;
    private int ano_letivo;
    private String turno;
    private int vagas;

    public Turma(int id, int instituicao_id, int professor_id, String nome, int ano_letivo, String turno, int vagas) {
        this.id = id;
        this.instituicao_id = instituicao_id;
        this.professor_id = professor_id;
        this.nome = nome;
        this.ano_letivo = ano_letivo;
        this.turno = turno;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(int instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_letivo() {
        return ano_letivo;
    }

    public void setAno_letivo(int ano_letivo) {
        this.ano_letivo = ano_letivo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString(){
        return String.format("ID: %d | Nome %s | Turno %s | Ano Letivo: %s | Vagas %d", id,nome,turno, ano_letivo, vagas);
    }
}
