package System;

import java.util.ArrayList;
import java.util.Scanner;

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

    public static void addE(ArrayList<System.Empregado> empregados, int ident, int identSind){

        Scanner input = new Scanner(System.in);
        String name, address, status, pagamento, taxas;
        double salario = 0, taxa = 0, taxa_extra = 0, taxa_sind = 0;
        System.CartaoPonto newC = new System.CartaoPonto(null, null, null, null);

        System.out.println("Digite o nome do novo empregado: ");
        name = input.nextLine();
        System.out.println("Digite o endereço: ");
        address = input.nextLine();
        System.out.println("Digite o tipo de empregado: ");
        status = input.nextLine();
        System.out.println("Qual a forma de pagamento desejada ?");
        pagamento = input.nextLine();
        System.out.println("Qual o salário base que o empregado receberá:");
        salario = input.nextDouble();

        if(status.equals("Comissionado")){
            System.out.println("Qual a taxa de comissão que o empregado receberá");
            taxa = input.nextDouble();
        }
        if(ident == 0){
            System.out.println("Qual a taxa do sindicato ?");
            taxa_sind = input.nextDouble();
            String lixo = input.nextLine();
            System.out.println("Quais as taxas de serviços ");
            taxas = input.nextLine();
            System.out.println("Qual a taxa cobrada por esses serviços ?");
            taxa_extra = input.nextDouble();
            System.Salario newS = new System.Salario(salario, taxa_sind, taxa_extra, taxa, taxas);
            empregados.add(new System.Empregado(name, address, status, "Pertence",
                    0, identSind, pagamento, newC, newS));
        } else {
            System.Salario newS = new System.Salario(salario, 0, 0, taxa, null);
            empregados.add(new System.Empregado(name, address, status, "Não pertence",
                    ident, 0, pagamento, newC, newS));
        }

        System.out.println("System.Empregado adicionado ao sistema\n");
    }

    public static void removeE(ArrayList<System.Empregado> empregados){
        Scanner input = new Scanner(System.in);
        Boolean exist = false;
        System.out.println("Digite o nome do empregado a ser removido:");
        String name = input.nextLine();

        for(int i = 0; i < empregados.size(); i++){
            System.Empregado emp = empregados.get(i);
            if(emp.getName().equals(name)){
                empregados.remove(emp);
                System.out.println("System.Empregado removido com sucesso!\n");
                exist = true;
                break;
            }
        }
        if(!exist)
            System.out.println("System.Empregado não encontrado!\n");
    }

    public static void changeData(ArrayList<System.Empregado> empregados, int ident, int identSind){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do usuário que deseja alterar os dados:");
        String name = input.nextLine();
        System.Empregado aux = new System.Empregado(null, null, null, null, 0, 0, null, null, null);
        boolean flag = false;
        int escolha = 1;

        for(int i = 0; i < empregados.size(); i++){
            aux = empregados.get(i);
            if(aux.getName().equals(name)){
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("System.Empregado não encontrado!");
        } else {
            while (escolha != 0) {
                System.out.println("1. Alterar nome\n2. Alterar endereço\n3. Alterar tipo de empregado\n" +
                        "4. Alterar método de pagamento\n5. Alterar vínculo com sinditaco\n" +
                        "6. Alterar identificação do sindicato\n7. Alterar taxa sindical\n0. Sair");

                escolha = input.nextInt();
                String lixo = input.nextLine();
                if(escolha == 1){
                    System.out.println("Digite o novo nome:");
                    name = input.nextLine();
                    aux.setName(name);
                } else if(escolha == 2){
                    System.out.println("Digite o novo endereço:");
                    name = input.nextLine();
                    aux.setAddress(name);
                } else if(escolha == 3){
                    System.out.println("Digite o novo tipo de empregado:");
                    name = input.nextLine();
                    aux.setStatus(name);
                } else if(escolha == 4){
                    System.out.println("Digite o novo método de pagamento");
                    name = input.nextLine();
                    aux.setPagamento(name);
                } else if(escolha == 5){
                    System.out.println("Pertence ou não ao sindicato ?");
                    name = input.nextLine();
                    aux.setSindicato(name);
                } else if(escolha == 6){
                    System.out.println("Digite nova identificação do sindicato:");
                    ident = input.nextInt();
                    aux.setIdentSind(ident);
                } else if(escolha == 7){
                    System.out.println("Digite a nova taxa sindical:");
                    double taxa = input.nextDouble();
                    aux.getSalario().setTaxa_sind(taxa);
                }
            }
            System.out.println("Dados alterados com sucesso!\n");
        }
    }
}