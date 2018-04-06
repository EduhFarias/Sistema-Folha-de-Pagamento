package System;

import Util.Date;
import Util.Hour;
import java.util.*;

import static Util.Useful.cont;

public class CartaoPonto {

    private int in_out = 0;
    private Date dInicio;
    private Date dFim;
    private Hour hInicio;
    private Hour hFim;

    public CartaoPonto(Date dInicio, Hour hInicio, Date dFim, Hour hFim) {
        this.in_out = 0;
        this.dInicio = dInicio;
        this.dFim = dFim;
        this.hInicio = hInicio;
        this.hFim = hFim;
    }

    public int getIn_out() {
        return in_out;
    }

    public void setIn_out(int in_out) {
        this.in_out = in_out;
    }

    public Date getdInicio() {
        return dInicio;
    }

    public void setdInicio(Date dInicio) {
        this.dInicio = dInicio;
    }

    public Date getdFim() {
        return dFim;
    }

    public void setdFim(Date dFim) {
        this.dFim = dFim;
    }

    public Hour gethInicio() {
        return hInicio;
    }

    public void sethInicio(Hour hInicio) {
        this.hInicio = hInicio;
    }

    public Hour gethFim() {
        return hFim;
    }

    public void sethFim(Hour hFim) {
        this.hFim = hFim;
    }

    public static void baterP(ArrayList<System.Empregado> empregados) {
        Scanner input = new Scanner(System.in);
        int day, month, year, hr, min, seg;
        boolean exist = false;
        Date data;
        Hour horario;
        System.out.println("Número de identificação do empregado: ");
        int ident = input.nextInt();

        for (int i = 0; i < empregados.size(); i++) {
            System.Empregado emp = empregados.get(i);

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

                    System.CartaoPonto newP = new System.CartaoPonto(data, horario, null, null);
                    emp.setPonto(newP);
                    emp.getPonto().setIn_out(1);
                    System.out.println("System.Empregado chegando a empresa\n");
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

                    System.CartaoPonto newP = new System.CartaoPonto(emp.getPonto().getdInicio(), emp.getPonto().gethInicio(),
                            data, horario);
                    emp.setPonto(newP);
                    emp.getPonto().setIn_out(0);
                    System.out.println("System.Empregado saindo da empresa\n");
                    if (emp.getStatus().equals("Horista")) {
                        cont(emp);
                    }
                }
                exist = true;
                break;
            }
        }
        if(!exist)
            System.out.println("System.Empregado não encontrado");
    }
}
