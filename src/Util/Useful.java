package Util;

public class Useful {
    public static void cont(System.Empregado empregado){
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
        if(hrsF < hrsI){
            hrsF+=12;
            hrsI-=12;
        }
        hr = hrsF -hrsI;
        if(hr > 8){
            aux = hr - 8;
        }
        empregado.getSalario().setPay(empregado.getSalario().getPay() + empregado.getSalario().getSalario_base()*(hr - aux) +
                ((empregado.getSalario().getSalario_base()*1.5)*aux ));
    }
}
