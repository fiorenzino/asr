package it.ictgroup.asr.model;

import java.util.Date;

import it.ictgroup.asr.util.annotations.FieldDatePattern;
import it.ictgroup.asr.util.annotations.FieldFixedLength;
import it.ictgroup.asr.util.annotations.FieldIgnored;
import it.ictgroup.asr.util.annotations.FixedLengthRecord;
import it.ictgroup.asr.util.enums.FixedMode;

import javax.persistence.Entity;
import javax.persistence.Table;

@FixedLengthRecord(fixedMode = FixedMode.AllowVariableLength)
@Entity
@Table(name = Flussoa1.TABLE_NAME)
public class Flussoa1 extends BaseFlusso
{
   @FieldIgnored
   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "flussoa1";

   // 1-8
   // Codice istituto di ricovero
   // AN
   // 8
   @FieldFixedLength(8)
   public String codiceIstitutoDiRicovero;
   // 9-16
   // Numero della scheda
   // AN
   // 8
   @FieldFixedLength(8)
   public String numeroDellaScheda;
   // 17-19
   // Regione addebitante
   // AN
   // 3
   @FieldFixedLength(3)
   public String regioneAddebitante;
   // 20-22
   // Azienda U.S.L./Ospedaliera inviante
   // AN
   // 3
   @FieldFixedLength(3)
   public String aziendaUsl;
   // 23-52
   // Cognome dell’utente
   // AN
   // 30
   @FieldFixedLength(30)
   public String cognomeDellUtente;
   // 53-72
   // Nome dell’utente
   // AN
   // 20
   @FieldFixedLength(20)
   public String nomeDellUtente;
   // 73
   // Sesso dell’utente
   // AN
   // 1
   @FieldFixedLength(1)
   public String sessoDellUtente;
   // 74-81
   // data di nascita dell’utente
   // data
   // 8
   @FieldFixedLength(8)
   @FieldDatePattern("ddMMyyyy")
   public Date dataDiNascitaDellUtente;
   // 82-87
   // comune di nascita dell’utente
   // AN
   // 6
   @FieldFixedLength(6)
   public String comuneDiNascitaDellUtente;

   // 88
   // stato civile dell’utente
   // AN
   // 1
   @FieldFixedLength(1)
   public String statoCivileDellUtente;
   // 89
   // titolo di studio dell’utente
   // AN
   // 1
   @FieldFixedLength(1)
   public String titoloDiStudioDellUtente;
   // 90-92
   // Cittadinanza dell’utente
   // AN
   // 3
   @FieldFixedLength(3)
   public String cittadinanzaDellUtente;
   // 93-108
   // codice fiscale dell’utente
   // AN
   // 16
   @FieldFixedLength(16)
   public String codiceFiscaleDellUtente;
   // 109-124
   // codice sanitario individuale dell’utente
   // AN
   // 16
   @FieldFixedLength(16)
   public String codiceSanitarioIndividualeDellUtente;

   // 125-130
   // comune di residenza dell’utente
   // AN
   // 6
   @FieldFixedLength(6)
   public String comuneDiResidenzaDellUtente;
   // 131-133
   // regione di residenza dell’utente
   // AN
   // 3
   @FieldFixedLength(3)
   public String regioneDiResidenzaDellUtente;
   // 134-136
   // azienda U.S.L. di residenza dell’utente
   // AN
   // 3
   @FieldFixedLength(3)
   public String aziendaUslDiResidenzaDellUtente;
   // 137-152
   // codice fiscale medico prescrittore
   // AN
   // 16
   @FieldFixedLength(16)
   public String codiceFiscaleMedicoPrescrittore;
   // 153-168
   // codice regionale medico prescrittore
   // AN
   // 16
   @FieldFixedLength(16)
   public String codiceRegionaleMedicoPrescrittore;
   // 169
   // posizione contabile
   // AN
   // 1
   @FieldFixedLength(1)
   public String posizioneContabile;

   public String getCodiceIstitutoDiRicovero()
   {
      return codiceIstitutoDiRicovero;
   }

   public void setCodiceIstitutoDiRicovero(String codiceIstitutoDiRicovero)
   {
      this.codiceIstitutoDiRicovero = codiceIstitutoDiRicovero;
   }

   public String getNumeroDellaScheda()
   {
      return numeroDellaScheda;
   }

   public void setNumeroDellaScheda(String numeroDellaScheda)
   {
      this.numeroDellaScheda = numeroDellaScheda;
   }

   public String getRegioneAddebitante()
   {
      return regioneAddebitante;
   }

   public void setRegioneAddebitante(String regioneAddebitante)
   {
      this.regioneAddebitante = regioneAddebitante;
   }

   public String getAziendaUsl()
   {
      return aziendaUsl;
   }

   public void setAziendaUsl(String aziendaUsl)
   {
      this.aziendaUsl = aziendaUsl;
   }

   public String getCognomeDellUtente()
   {
      return cognomeDellUtente;
   }

   public void setCognomeDellUtente(String cognomeDellUtente)
   {
      this.cognomeDellUtente = cognomeDellUtente;
   }

   public String getNomeDellUtente()
   {
      return nomeDellUtente;
   }

   public void setNomeDellUtente(String nomeDellUtente)
   {
      this.nomeDellUtente = nomeDellUtente;
   }

   public String getSessoDellUtente()
   {
      return sessoDellUtente;
   }

   public void setSessoDellUtente(String sessoDellUtente)
   {
      this.sessoDellUtente = sessoDellUtente;
   }

   public Date getDataDiNascitaDellUtente()
   {
      return dataDiNascitaDellUtente;
   }

   public void setDataDiNascitaDellUtente(Date dataDiNascitaDellUtente)
   {
      this.dataDiNascitaDellUtente = dataDiNascitaDellUtente;
   }

   public String getComuneDiNascitaDellUtente()
   {
      return comuneDiNascitaDellUtente;
   }

   public void setComuneDiNascitaDellUtente(String comuneDiNascitaDellUtente)
   {
      this.comuneDiNascitaDellUtente = comuneDiNascitaDellUtente;
   }

   public String getStatoCivileDellUtente()
   {
      return statoCivileDellUtente;
   }

   public void setStatoCivileDellUtente(String statoCivileDellUtente)
   {
      this.statoCivileDellUtente = statoCivileDellUtente;
   }

   public String getTitoloDiStudioDellUtente()
   {
      return titoloDiStudioDellUtente;
   }

   public void setTitoloDiStudioDellUtente(String titoloDiStudioDellUtente)
   {
      this.titoloDiStudioDellUtente = titoloDiStudioDellUtente;
   }

   public String getCittadinanzaDellUtente()
   {
      return cittadinanzaDellUtente;
   }

   public void setCittadinanzaDellUtente(String cittadinanzaDellUtente)
   {
      this.cittadinanzaDellUtente = cittadinanzaDellUtente;
   }

   public String getCodiceFiscaleDellUtente()
   {
      return codiceFiscaleDellUtente;
   }

   public void setCodiceFiscaleDellUtente(String codiceFiscaleDellUtente)
   {
      this.codiceFiscaleDellUtente = codiceFiscaleDellUtente;
   }

   public String getCodiceSanitarioIndividualeDellUtente()
   {
      return codiceSanitarioIndividualeDellUtente;
   }

   public void setCodiceSanitarioIndividualeDellUtente(String codiceSanitarioIndividualeDellUtente)
   {
      this.codiceSanitarioIndividualeDellUtente = codiceSanitarioIndividualeDellUtente;
   }

   public String getComuneDiResidenzaDellUtente()
   {
      return comuneDiResidenzaDellUtente;
   }

   public void setComuneDiResidenzaDellUtente(String comuneDiResidenzaDellUtente)
   {
      this.comuneDiResidenzaDellUtente = comuneDiResidenzaDellUtente;
   }

   public String getRegioneDiResidenzaDellUtente()
   {
      return regioneDiResidenzaDellUtente;
   }

   public void setRegioneDiResidenzaDellUtente(String regioneDiResidenzaDellUtente)
   {
      this.regioneDiResidenzaDellUtente = regioneDiResidenzaDellUtente;
   }

   public String getAziendaUslDiResidenzaDellUtente()
   {
      return aziendaUslDiResidenzaDellUtente;
   }

   public void setAziendaUslDiResidenzaDellUtente(String aziendaUslDiResidenzaDellUtente)
   {
      this.aziendaUslDiResidenzaDellUtente = aziendaUslDiResidenzaDellUtente;
   }

   public String getCodiceFiscaleMedicoPrescrittore()
   {
      return codiceFiscaleMedicoPrescrittore;
   }

   public void setCodiceFiscaleMedicoPrescrittore(String codiceFiscaleMedicoPrescrittore)
   {
      this.codiceFiscaleMedicoPrescrittore = codiceFiscaleMedicoPrescrittore;
   }

   public String getCodiceRegionaleMedicoPrescrittore()
   {
      return codiceRegionaleMedicoPrescrittore;
   }

   public void setCodiceRegionaleMedicoPrescrittore(String codiceRegionaleMedicoPrescrittore)
   {
      this.codiceRegionaleMedicoPrescrittore = codiceRegionaleMedicoPrescrittore;
   }

   public String getPosizioneContabile()
   {
      return posizioneContabile;
   }

   public void setPosizioneContabile(String posizioneContabile)
   {
      this.posizioneContabile = posizioneContabile;
   }

   @Override
   public String toString()
   {
      return "Flussoa1 ["
               + (super.getUid() != null ? "uid=" + super.getUid() + ", " : "")
               + (codiceIstitutoDiRicovero != null ? "codiceIstitutoDiRicovero=" + codiceIstitutoDiRicovero + ", " : "")
               + (numeroDellaScheda != null ? "numeroDellaScheda=" + numeroDellaScheda + ", " : "")
               + (regioneAddebitante != null ? "regioneAddebitante=" + regioneAddebitante + ", " : "")
               + (aziendaUsl != null ? "aziendaUsl=" + aziendaUsl + ", " : "")
               + (cognomeDellUtente != null ? "cognomeDellUtente=" + cognomeDellUtente + ", " : "")
               + (nomeDellUtente != null ? "nomeDellUtente=" + nomeDellUtente + ", " : "")
               + (sessoDellUtente != null ? "sessoDellUtente=" + sessoDellUtente + ", " : "")
               + (dataDiNascitaDellUtente != null ? "dataDiNascitaDellUtente=" + dataDiNascitaDellUtente + ", " : "")
               + (comuneDiNascitaDellUtente != null ? "comuneDiNascitaDellUtente=" + comuneDiNascitaDellUtente + ", "
                        : "")
               + (statoCivileDellUtente != null ? "statoCivileDellUtente=" + statoCivileDellUtente + ", " : "")
               + (titoloDiStudioDellUtente != null ? "titoloDiStudioDellUtente=" + titoloDiStudioDellUtente + ", " : "")
               + (cittadinanzaDellUtente != null ? "cittadinanzaDellUtente=" + cittadinanzaDellUtente + ", " : "")
               + (codiceFiscaleDellUtente != null ? "codiceFiscaleDellUtente=" + codiceFiscaleDellUtente + ", " : "")
               + (codiceSanitarioIndividualeDellUtente != null ? "codiceSanitarioIndividualeDellUtente="
                        + codiceSanitarioIndividualeDellUtente + ", " : "")
               + (comuneDiResidenzaDellUtente != null ? "comuneDiResidenzaDellUtente=" + comuneDiResidenzaDellUtente
                        + ", " : "")
               + (regioneDiResidenzaDellUtente != null ? "regioneDiResidenzaDellUtente=" + regioneDiResidenzaDellUtente
                        + ", " : "")
               + (aziendaUslDiResidenzaDellUtente != null ? "aziendaUslDiResidenzaDellUtente="
                        + aziendaUslDiResidenzaDellUtente + ", " : "")
               + (codiceFiscaleMedicoPrescrittore != null ? "codiceFiscaleMedicoPrescrittore="
                        + codiceFiscaleMedicoPrescrittore + ", " : "")
               + (codiceRegionaleMedicoPrescrittore != null ? "codiceRegionaleMedicoPrescrittore="
                        + codiceRegionaleMedicoPrescrittore + ", " : "")
               + (posizioneContabile != null ? "posizioneContabile=" + posizioneContabile : "") + "]";
   }

}
