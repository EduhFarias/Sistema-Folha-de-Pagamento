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

}
