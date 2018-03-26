import java.util.*;

public class SystemMain {

    public static void main(String[] args){
        ArrayList<Empregado> empregados = new ArrayList<>();
        ArrayList<Empregado> previous = new ArrayList<>();
        int escolha = 1, ident = 1, identSind = 1;
        Scanner input = new Scanner(System.in);
        while(escolha != 0) {
            System.out.println("1. Adicionar empregado.\n2. Remover empregado.\n3. Lançar um cartão de ponto.\n" +
                    "4. Larçar um resultado de venda.\n5. Lançar uma taxa de serviço.\n6. Alterar informações de empregado.\n" +
                    "7. Rodar folha de pagamento para hoje.\n8. Agenda de pagamento.\n9. Criar nova agenda de pagamento.\n" +
                    "10. Desfazer/Refazer\n0. Sair");
            escolha = input.nextInt();
            String lixo = input.nextLine();
            if(escolha == 1){
                previous = empregados;
                System.out.println("O empregado está associado ao sindicado ?");
                String aux = input.nextLine();
                if(aux.equals("Sim")){
                    addE(empregados, 0, identSind);
                    identSind++;
                } else {
                    addE(empregados, ident, 0);
                    ident++;
                }
            } else if(escolha == 2){
                previous = empregados;
                removeE(empregados);
            } else if(escolha == 3){
                previous = empregados;
                baterP(empregados);
            } else if(escolha == 4){
                previous = empregados;
                resulVenda(empregados);
            } else if(escolha == 5){
                previous = empregados;
                taxaServ(empregados);
            } else if(escolha == 6){
                previous = empregados;
                changeData(empregados, ident, identSind);
            } else if(escolha == 7){
                previous = empregados;
                payment(empregados);
            } else if(escolha == 8){
                agenda(empregados);
            } else if(escolha == 9){
                System.out.println("Erro, opção indisponível no momento!");
            } else if(escolha == 10){
                empregados = previous;
                System.out.println("Ação desfeita!");
            }
        }
    }

    public static void addE(ArrayList<Empregado> empregados, int ident, int identSind){

        Scanner input = new Scanner(System.in);
        String name, address, status, pagamento, taxas;
        double salario = 0, taxa = 0, taxa_extra = 0, taxa_sind = 0;
        CartaoPonto newC = new CartaoPonto(null, null, null, null);

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
            Salario newS = new Salario(salario, taxa_sind, taxa_extra, taxa, taxas);
            empregados.add(new Empregado(name, address, status, "Pertence",
                    0, identSind, pagamento, newC, newS));
        } else {
            Salario newS = new Salario(salario, 0, 0, taxa, null);
            empregados.add(new Empregado(name, address, status, "Não pertence",
                    ident, 0, pagamento, newC, newS));
        }

        System.out.println("Empregado adicionado ao sistema\n");
    }

    public static void removeE(ArrayList<Empregado> empregados){
        Scanner input = new Scanner(System.in);
        Boolean exist = false;
        System.out.println("Digite o nome do empregado a ser removido:");
        String name = input.nextLine();

        for(int i = 0; i < empregados.size(); i++){
            Empregado emp = empregados.get(i);
            if(emp.getName().equals(name)){
                empregados.remove(emp);
                System.out.println("Empregado removido com sucesso!\n");
                exist = true;
                break;
            }
        }
        if(!exist)
            System.out.println("Empregado não encontrado!\n");
    }

    public static void baterP(ArrayList<Empregado> empregados) {
        Scanner input = new Scanner(System.in);
        int day, month, year, hr, min, seg;
        boolean exist = false;
        Date data;
        Hour horario;
        System.out.println("Número de identificação do empregado: ");
        int ident = input.nextInt();

        for (int i = 0; i < empregados.size(); i++) {
            Empregado emp = empregados.get(i);

            if (emp.getIdent() == ident || emp.getIdentSind() == ident) {
                if (emp.getPonto().getIn_out() == 0) {
                    System.out.println("Data de entrada: ");
                    day = input.nextInt();
                    month = input.nextInt();
                    year = input.nextInt();
                    data = new Date(day, month, year);

                    System.out.println("Horário de entrada:");
                    hr = input.nextInt();
                    min = input.nextInt();
                    seg = input.nextInt();
                    horario = new Hour(hr, min, seg);

                    CartaoPonto newP = new CartaoPonto(data, horario, null, null);
                    emp.setPonto(newP);
                    emp.getPonto().setIn_out(1);
                    System.out.println("Empregado chegando a empresa\n");
                } else {
                    System.out.println("Data de saída: ");
                    day = input.nextInt();
                    month = input.nextInt();
                    year = input.nextInt();
                    data = new Date(day, month, year);

                    System.out.println("Horário de saída:");
                    hr = input.nextInt();
                    min = input.nextInt();
                    seg = input.nextInt();
                    horario = new Hour(hr, min, seg);

                    CartaoPonto newP = new CartaoPonto(emp.getPonto().getdInicio(), emp.getPonto().gethInicio(),
                            data, horario);
                    emp.setPonto(newP);
                    emp.getPonto().setIn_out(0);
                    System.out.println("Empregado saindo da empresa\n");
                    if (emp.getStatus().equals("Horista")) {
                        cont(emp);
                    }
                }
                exist = true;
                break;
            }
        }
        if(!exist)
            System.out.println("Empregado não encontrado");
    }

    public static void cont(Empregado empregado){
        int hrsI = empregado.getPonto().gethInicio().getHrs();
        int minI = empregado.getPonto().gethInicio().getMin();
        int segI = empregado.getPonto().gethInicio().getSeg();

        int hrsF = empregado.getPonto().gethFim().getHrs();
        int minF = empregado.getPonto().gethFim().getMin();
        int segF = empregado.getPonto().gethFim().getSeg();

        int hr, min, seg, aux = 0;

        if(segF < segI){
            minF--;
            segF+=60;
        }
        seg = segF - segI;
        if(minF < minI){
            hrsF--;
            minF+=60;
        }
        min = minF - minI;
        hr = hrsF -hrsI;
        if(hr > 8){
            aux = hr - 8;
        }
        empregado.getSalario().setPay(empregado.getSalario().getPay() + empregado.getSalario().getSalario_base()*(hr - aux) +
                ((empregado.getSalario().getSalario_base()*1.5)*aux ));
    }

    public static void resulVenda(ArrayList<Empregado> empregados){
        Scanner input = new Scanner(System.in);
        boolean exist = false;
        System.out.println("Digite o nome do empregado:");
        String name = input.nextLine();

        for(Empregado emp : empregados){
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
            System.out.println("Empregado não encontrado");

    }

    public static void taxaServ(ArrayList<Empregado> empregados){
        Scanner input = new Scanner(System.in);
        String name, taxa;
        boolean exist = false;

        System.out.println("Digite o nome do empregado:");
        name = input.nextLine();
        for(Empregado emp : empregados){
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
        System.out.println("Empregado não encontrado");
    }

    public static void changeData(ArrayList<Empregado> empregados, int ident, int identSind){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do usuário que deseja alterar os dados:");
        String name = input.nextLine();
        Empregado aux = new Empregado(null, null, null, null, 0, 0, null, null, null);
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
            System.out.println("Empregado não encontrado!");
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

    public static void payment(ArrayList<Empregado> empregados){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o dia atual: ");
        String dia = input.nextLine();

        System.out.println("Digite o dia, mes e ano atual:");
        int day, month, year;
        day = input.nextInt();
        month = input.nextInt();
        year = input.nextInt();

        if(dia.equals("Sexta-feira")){
            for(Empregado emp : empregados){
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
                for (Empregado emp : empregados) {
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

    public static void undo_redo(){
        /*
        * Fazer um arrayList aux. Toda vez que for iniciar uma ação, o arrayList aux recebe o arrayList atual
        * Qdo chamar a função desfazer/refazer o arrayList atual recebe o aux
        * */
    }

    public static void agenda(ArrayList<Empregado> empregados){
        System.out.println("Empregados pagos semanalmente: ");
        for(Empregado emp : empregados){
            if(emp.getStatus().equals("Horista")){
                System.out.println(emp.getName());
            }
        }
        System.out.println("\n--------------------------------------------------------------------------\n");
        System.out.println("Empregados pagos bi-semanalmente: ");
        for(Empregado emp : empregados){
            if(emp.getStatus().equals("Comissionado")){
                System.out.println(emp.getName());
            }
        }
        System.out.println("\n--------------------------------------------------------------------------\n");
        System.out.println("Empregados pagos mensalmente: ");
        for(Empregado emp : empregados){
            if(emp.getStatus().equals("Assalariado")){
                System.out.println(emp.getName());
            }
        }
    }

    public static void createAgenda(){
        //Cria um novo tipo de dia de pagamento, ainda n sei como
    }
}
