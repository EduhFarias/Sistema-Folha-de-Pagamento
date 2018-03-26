public class Salario {

    private double salario_base;
    private double pay = 0;
    private double taxa_sind;
    private double taxa_extra;
    private double taxa_comissao;
    private int pagar_comissionado;
    private String taxas_serviços;

    public int getPagar_comissionado() {
        return pagar_comissionado;
    }

    public void setPagar_comissionado(int pagar_comissionado) {
        this.pagar_comissionado = pagar_comissionado;
    }

    public String getTaxas_serviços() {
        return taxas_serviços;
    }

    public void setTaxas_serviços(String taxas_serviços) {
        this.taxas_serviços = taxas_serviços;
    }

    public Salario(double salario_base, double taxa_sind, double taxa_extra, double taxa_comissao, String taxas_serviços) {
        this.salario_base = salario_base;
        this.taxa_sind = taxa_sind;
        this.taxa_extra = taxa_extra;
        this.taxa_comissao = taxa_comissao;
        this.pagar_comissionado = 1;
        this.taxas_serviços = taxas_serviços;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(double salario_base) {
        this.salario_base = salario_base;
    }

    public double getTaxa_sind() {
        return taxa_sind;
    }

    public void setTaxa_sind(double taxa_sind) {
        this.taxa_sind = taxa_sind;
    }

    public double getTaxa_extra() {
        return taxa_extra;
    }

    public void setTaxa_extra(double taxa_extra) {
        this.taxa_extra = taxa_extra;
    }

    public double getTaxa_comissao() {
        return taxa_comissao;
    }

    public void setTaxa_comissao(double taxa_comissao) {
        this.taxa_comissao = taxa_comissao;
    }
}
