package System;

import java.util.*;

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

    public static void payment(ArrayList<System.Empregado> empregados){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o dia atual: ");
        String dia = input.nextLine();

        System.out.println("Digite o dia, mes e ano atual:");
        int day, month, year;
        day = input.nextInt();
        month = input.nextInt();
        year = input.nextInt();

        if(dia.equals("Sexta-feira")){
            for(System.Empregado emp : empregados){
                double taxa_sind = (emp.getSalario().getTaxa_sind()) / 100;
                double taxa_extra = (emp.getSalario().getTaxa_extra()) / 100;
                double pay = emp.getSalario().getPay();
                double salario = pay - ((pay*taxa_extra) + (pay*taxa_sind));

                if(emp.getStatus().equals("Horista")) {
                    System.out.println("Nome: " + emp.getName() + "\nEndereço: " + emp.getAddress() + "\nStatus: " + emp.getStatus()
                            + "\nOpção de pagamento: " + emp.getPagamento() + "\nRelação com o sindicato: " + emp.getSindicato());
                    if (emp.getSindicato().equals("Pertence")) {
                        System.out.println(" Identificação: " + emp.getIdentSind() + " Taxa sindical: "
                                + emp.getSalario().getTaxa_sind() + "%");
                    } else System.out.println("\nIdentificação: " + emp.getIdent());
                    System.out.println("\nSalário base: " + emp.getSalario().getSalario_base() + "\nDeduções: "
                            + emp.getSalario().getTaxas_serviços() + " -> " + emp.getSalario().getTaxa_extra()
                            + "%" + "\nSalário: " + emp.getSalario().getPay() + "\nSalário final(com deduções): "
                            + salario + "\n");

                    emp.getSalario().setPay(0);
                } else if(emp.getStatus().equals("Comissionado")){
                    if(emp.getSalario().getPagar_comissionado() == 1){
                        emp.getSalario().setPagar_comissionado(0);
                    } else if(emp.getSalario().getPagar_comissionado() == 0){
                        System.out.println("Nome: " + emp.getName() + "\nEndereço: " + emp.getAddress() + "\nStatus: " + emp.getStatus()
                                + "\nOpção de pagamento: " + emp.getPagamento() + "\nRelação com o sindicato: " + emp.getSindicato());
                        if (emp.getSindicato().equals("Pertence")) {
                            System.out.println(" Identificação: " + emp.getIdentSind() + " Taxa sindical: "
                                    + emp.getSalario().getTaxa_sind() + "%");
                        } else System.out.println("Identificação: " + emp.getIdent());
                        System.out.println("Taxa de comissão por venda: " + emp.getSalario().getTaxa_comissao()+ "%"
                                + "\nSalário base: " + emp.getSalario().getSalario_base() + "\nDeduções: "
                                + emp.getSalario().getTaxas_serviços() + " -> " + emp.getSalario().getTaxa_extra()
                                + "%" + "\nSalário: " + emp.getSalario().getPay() + "\nSalário final(com deduções): "
                                + salario + "\n");
                        emp.getSalario().setPagar_comissionado(0);
                        emp.getSalario().setPay(emp.getSalario().getSalario_base());
                    }
                }
            }
        }

        if( (!(dia.equals("Sábado")) || !(dia.equals("Domingo")))){
            if((month == 2 && day >= 26) || day >= 28) {
                for (System.Empregado emp : empregados) {
                    double taxa_sind = (emp.getSalario().getTaxa_sind()) / 100;
                    double taxa_extra = (emp.getSalario().getTaxa_extra()) / 100;
                    double pay = emp.getSalario().getSalario_base();
                    double salario = pay - ((pay * taxa_extra) + (pay * taxa_sind));

                    System.out.println("Nome: " + emp.getName() + "\nEndereço: " + emp.getAddress() + "\nStatus: " + emp.getStatus()
                            + "\nOpção de pagamento: " + emp.getPagamento() + "\nRelação com o sindicato: " + emp.getSindicato());
                    if (emp.getSindicato().equals("Pertence")) {
                        System.out.println(" Identificação: " + emp.getIdentSind() + " Taxa sindical: "
                                + emp.getSalario().getTaxa_sind() + "%");
                    } else System.out.println("Identificação: " + emp.getIdent());
                    System.out.println("Salário base: " + emp.getSalario().getSalario_base() + "\nDeduções: "
                            + emp.getSalario().getTaxas_serviços() + " -> " + emp.getSalario().getTaxa_extra()
                            + "%" + "\nSalário final(com deduções): " + salario + "\n");
                }
            }
        }
    }

    public static void agenda(ArrayList<System.Empregado> empregados){
        System.out.println("Empregados pagos semanalmente: ");
        for(System.Empregado emp : empregados){
            if(emp.getStatus().equals("Horista")){
                System.out.println(emp.getName());
            }
        }
        System.out.println("\n--------------------------------------------------------------------------\n");
        System.out.println("Empregados pagos bi-semanalmente: ");
        for(System.Empregado emp : empregados){
            if(emp.getStatus().equals("Comissionado")){
                System.out.println(emp.getName());
            }
        }
        System.out.println("\n--------------------------------------------------------------------------\n");
        System.out.println("Empregados pagos mensalmente: ");
        for(System.Empregado emp : empregados){
            if(emp.getStatus().equals("Assalariado")){
                System.out.println(emp.getName());
            }
        }
    }

    public static void resulVenda(ArrayList<System.Empregado> empregados){
        Scanner input = new Scanner(System.in);
        boolean exist = false;
        System.out.println("Digite o nome do empregado:");
        String name = input.nextLine();

        for(System.Empregado emp : empregados){
            if(emp.getName().equals(name)){
                if(emp.getStatus().equals("Comissionado")){
                    System.out.println("Resultado de venda do empregado:");
                    double venda = input.nextDouble();
                    double taxa = emp.getSalario().getTaxa_comissao();
                    emp.getSalario().setPay(emp.getSalario().getPay() + (emp.getSalario().getSalario_base()+(venda*(taxa/100))) );
                    exist = true;
                    break;
                } else{
                    System.out.println("O empregado não é comissionado");
                    break;
                }
            }
        }
        if(!exist)
            System.out.println("System.Empregado não encontrado");

    }

    public static void taxaServ(ArrayList<System.Empregado> empregados){
        Scanner input = new Scanner(System.in);
        String name, taxa;
        boolean exist = false;

        System.out.println("Digite o nome do empregado:");
        name = input.nextLine();
        for(System.Empregado emp : empregados){
            if(emp.getName().equals(name)){
                System.out.println("Qual taxa de serviço será adicionada ?");
                taxa = input.nextLine();
                emp.getSalario().setTaxas_serviços(taxa);
                System.out.println("Qual taxa será cobrada pelo serviço ?");
                double taxa_extra = input.nextDouble();
                emp.getSalario().setTaxa_extra(taxa_extra);
                System.out.println("Taxa de serviço atualizada");
                exist = true;
                break;
            }
        }
        System.out.println("System.Empregado não encontrado");
    }
}
