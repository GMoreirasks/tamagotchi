import java.util.Random;

public class Tamagotchi {
    private String nome;
    private int idade;
    private int saude;
    private int fome;
    private int limpeza;
    private int socializacao;
    private int energia;
    private boolean vivo;
    private String causaDaMorte;

    public Tamagotchi(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.saude = 100;
        this.fome = 100;
        this.limpeza = 100;
        this.socializacao = 100;
        this.energia = 100;
        this.vivo = true;
        this.causaDaMorte = null;
    }

    public String alimentar() {
        if(this.vivo) {
            Random rand = new Random();
            int eventoAleatorioMorte = rand.nextInt(1000) + 1;
            if(eventoAleatorioMorte == 1) {
                eventoDeMorte("Seu Tamagotchi engasgou e foi de F");
            }
            if(fome == 100) {
                return "Nao consigo comer, estou muito cheio!";
            }

            int eventoAleatorio = rand.nextInt(10) + 1;
            String idade = getIdade();
            if(idade == "Bebe" && eventoAleatorio == 1) {
                incrementLimpeza(-30);
            }

            incrementFome(20);
            incrementEnergia(20);

            return "Hmmmmm que delicia!";
        }

        return getMensagemMorto();
    }

    public String brincar() {
        if(this.vivo) {
            Random rand = new Random();
            int eventoAleatorioMorte = rand.nextInt(100) + 1;
            if(eventoAleatorioMorte == 1) {
                eventoDeMorte("Seu Tamagotchi foi atropelado e foi de F");
            }

            if(energia < 20) {
                return "Nao consigo brincar, estou muito cansado!";
            }

            int eventoAleatorio = rand.nextInt(10) + 1;

            if(eventoAleatorio == 1) {
                incrementSaude(-50);
            }

            incrementEnergia(-20);
            incrementFome(-20);

            String idade = getIdade();
            if(idade == "Bebe") {
                incrementLimpeza(-60);
            } else if(idade == "Adolescente") {
                incrementLimpeza(-40);
            } else {
                incrementLimpeza(-20);
            }

            incrementSocializacao(30);
            incrementIdade(1);

            return "Adoro brincar com meu mestre!";
        }

        return getMensagemMorto();
    }

    public String dormir() {
        if(this.vivo) {
            if(getLimpeza() == "Nojento") {
                return "Não consigo dormir, estou muito sujo!";
            }

            Random rand = new Random();
            int eventoAleatorioDoente = rand.nextInt(10) + 1;
            if(eventoAleatorioDoente == 1) {
                incrementSaude(-50);
            }
            int eventoAleatorioPesadelo = rand.nextInt(10) + 1;
            if(eventoAleatorioPesadelo == 1) {
                incrementEnergia(-50);
            }

            incrementEnergia(50);
            incrementSocializacao(-30);
            incrementFome(-40);
            incrementSaude(10);
            incrementIdade(2);

            return "Soninho bao";
        }

        return getMensagemMorto();
    }

    public String tomarBanho() {
        if(this.vivo) {
            incrementLimpeza(100);

            return "To nos trinques papai";
        }

        return getMensagemMorto();
    }

    public String toString() {
        String toString = "";
        if(this.vivo) {
            toString += "Nome: " + this.getNome() + "\n";
            toString += "Idade: " + this.getIdade() + "\n";
            toString += "Saude: " + this.getSaude() + "\n";
            toString += "Fome: " + this.getFome() + "\n";
            toString += "Limpeza: " + this.getLimpeza() + "\n";
            toString += "Socializacao: " + this.getSocializacao() + "\n";
            toString += "Energia: " + this.getEnergia();
        } else {
            toString = getMensagemMorto();
        }

        return toString;
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        if(idade < 10) {
            return "Bebe";
        } else if(idade < 20) {
            return "Adolescente";
        }

        return "Adulto";
    }

    public String getSaude() {
        if(saude < 30) {
            return "Doente";
        }

        return "Saudavel";
    }

    public String getFome() {
        if(fome < 30) {
            return "Faminto";
        } else if(fome < 50) {
            return "Alimentado";
        }

        return "Cheio";
    }

    public String getLimpeza() {
        if(limpeza < 10) {
            return "Nojento";
        } else if(limpeza < 30) {
            return "Muito sujo";
        } else if(limpeza < 50) {
            return "Sujo";
        } else if(limpeza < 80) {
            return "Limpo";
        }

        return "Brilhando";
    }

    public String getSocializacao() {
        if(socializacao < 10) {
            return "Insuportável";
        } else if(socializacao < 30) {
            return "Chato";
        } else if(socializacao < 50) {
            return "De boa";
        } else if(socializacao < 70) {
            return "Feliz";
        }

        return "Radiante";
    }

    public String getEnergia() {
        if(energia < 20) {
            return "Dormindo em pé";
        } else if(energia < 40) {
            return "Cansado";
        } else if(energia < 70) {
            return "Descansado";
        }

        return "Pronto para peripecias";
    }

    public String getVivo() {
        if(vivo) {
            return "Vivo";
        }

        return "Morto";
    }

    public String getCausaDaMorte() {
        return causaDaMorte;
    }

    public String getMensagemMorto() {
        return "Seu Tamagotchi esta morto\nCausa da Morte: " + getCausaDaMorte();
    }

    public void eventoDeMorte(String causaDaMorte) {
        this.vivo = false;
        this.causaDaMorte = causaDaMorte;
    }

    public void incrementIdade(int idade) {
        this.idade += idade;

        if(this.idade > 100) {
            eventoDeMorte("Seu Tamagotchi ficou velho demais e foi de F");
        }
    }

    public void incrementSaude(int saude) {
        this.saude += saude;

        if(getLimpeza() == "Nojento") {
            this.saude -= 20;
        }

        if(this.saude < 10) {
            eventoDeMorte("Seu Tamagotchi ficou muito debilitado e foi de F");
        } else if(this.saude > 100) {
            this.saude = 100;
        }
    }

    public void incrementFome(int fome) {
        this.fome += fome;

        if(this.fome == 0) {
            eventoDeMorte("Seu Tamagotchi ficou faminto e foi de F");
        } else if(this.fome > 100) {
            this.fome = 100;
        }
    }

    public void incrementLimpeza(int limpeza) {
        this.limpeza += limpeza;

        if(this.limpeza > 100) {
            this.limpeza = 100;
        }
    }

    public void incrementSocializacao(int socializacao) {
        this.socializacao += socializacao;

        if(this.socializacao == 0) {
            eventoDeMorte("Seu Tamagotchi ficou depressivo e foi de F");
        } else if(this.socializacao > 100) {
            this.socializacao = 100;
        }
    }

    public void incrementEnergia(int energia) {
        this.energia += energia;

        if(this.energia == 0) {
            eventoDeMorte("Seu Tamagotchi ficou muito cansado e foi de F");
        } else if(this.energia > 100) {
            this.energia = 100;
        }
    }

}
