public class Empregado {

    private String name;
    private String address;
    private String status; //Horista, mensal, comissionado
    private String sindicato; //pertence ou nao
    private int ident;
    private int identSind;  //diff da ident do empregado
    private String pagamento; //cheque p/correios, cheque/direto, deposito
    private CartaoPonto ponto;
    private Salario salario;


    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public Empregado(String name, String address, String status, String sindicato,
                     int ident, int identSind, String pagamento, CartaoPonto ponto, Salario salario) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.sindicato = sindicato;
        this.ident = ident;
        this.identSind = identSind;
        this.pagamento = pagamento;
        this.ponto = ponto;
        this.salario = salario;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public String getSindicato() {
        return sindicato;
    }

    public int getIdent() {
        return ident;
    }

    public int getIdentSind() {
        return identSind;
    }

    public String getPagamento() {
        return pagamento;
    }

    public CartaoPonto getPonto() {
        return ponto;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSindicato(String sindicato) {
        this.sindicato = sindicato;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public void setIdentSind(int identSind) {
        this.identSind = identSind;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public void setPonto(CartaoPonto ponto){
        this.ponto = ponto;
    }

}