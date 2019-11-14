<template>
  <div id="app">
    <div class="container">
      <app-form v-on:receive-data="setPayload" />
      <br />
      <recommendation-card v-for="(item, index) in response" :key="index" :recommendation="item" />
    </div>
  </div>
</template>

<script>
import AppForm from "./components/AppForm.vue";
import RecommendationCard from "./components/RecommendationCard.vue";

export default {
  name: "app",
  components: {
    AppForm,
    RecommendationCard
  },
  data() {
    return {
      response: [],
      recommendations: ""
    };
  },
  methods: {
    do_request(payload) {
      this.$axios
        .get(this.$BaseUrl + this.recommendations, {
          headers: {
            Authorization:
              "Bearer 689b0a159879332335d84b6ff4a61a0e6c1619fd8022c39e95ad5d9d3f81",
            "Content-Type": "application/json"
          },
          params: payload
        })
        .then(response => {
          this.response = response.data.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    setPayload(data) {
      var payload = {};

      //For the request path
      this.recommendations = data.recommendations;

      //Sex
      payload["sex"] = data.sex;

      //Sets pregnant if sex is female and field is filled
      if (data.sex === "f") {
        if (data.pregnant) {
          payload["pregnant"] = data.pregnant;
        }
      }

      //Sets age or dey of birth
      if (data.ageOrBirthdayPicked === "age") {
        payload["age"] = data.age;
      } else {
        var dob = new Date(data.dob);
        payload["dob"] = dob.toISOString().split("T")[0];
      }

      //Sets ethnicity
      payload["ethnicity"] = data.ethnicity;

      //if is smoker, sets packs per day and years smoking
      if (data.smokerPicked) {
        payload["ppd"] = data.ppd;
        payload["years_smoking"] = data.years_smoking;
      }

      //if is body mass index is picked, set the bmi or the units to calculate it
      if (data.bodyMassIndexPicked) {
        if (data.bmiOrCalculatePicked === "bmi") {
          payload["bmi"] = data.bmi;
        } else {
          if (data.unitsSystem === "is") {
            payload["kg"] = data.kg;
            payload["m"] = data.m;
          } else {
            payload["lbs"] = data.lbs;
            payload["inches"] = data.inches;
          }
        }
      }

      //Sets the tuberculosis skin test
      if (data.tstPicked) {
        payload["tst"] = data.tst;
      }

      //Sets the systolic blood pressure
      if (data.sbpPicked) {
        payload["sbp"] = data.sbp;
      }

      //Sets the diastolic blood pressure
      if (data.dbpPicked) {
        payload["dbp"] = data.dbp;
      }

      //Sets the low-density lipoprotein (LDL)
      if (data.ldlPicked) {
        payload["ldl"] = data.ldl;
      }

      //Sets the triglycerides
      if (data.trigsPicked) {
        payload["trigs"] = data.trigs;
      }

      //Sets the coronary artery calsium
      if (data.cacPicked) {
        payload["cac"] = data.cac;
      }

      //Sets all the possible conditions of a person
      if (data.conditionsPicked) {
        var conditions_string = "";

        conditions_string += data.dm ? "dm," : "";
        conditions_string += data.obese ? "obese," : "";
        conditions_string += data.hiv ? "hiv," : "";
        conditions_string += data.sti ? "sti," : "";
        conditions_string += data.postmenopause ? "postmenopause," : "";
        conditions_string += data.ivda ? "ivda," : "";
        conditions_string += data.hca ? "hca," : "";
        conditions_string += data.liver ? "liver," : "";
        conditions_string += data.prison ? "prison," : "";
        conditions_string += data.dialysis ? "dialysis," : "";
        conditions_string += data.asplenia ? "asplenia," : "";
        conditions_string += data.scd ? "scd," : "";
        conditions_string += data.htn ? "htn," : "";
        conditions_string += data.heart ? "heart," : "";
        conditions_string += data.lung ? "lung," : "";
        conditions_string += data.csf ? "csf," : "";
        conditions_string += data.cochlear ? "cochlear," : "";
        conditions_string += data.ckd ? "ckd," : "";
        conditions_string += data.ca ? "ca," : "";
        conditions_string += data.smoker ? "smoker," : "";
        conditions_string += data.alcohol ? "alcohol," : "";
        conditions_string += data.transplant ? "transplant," : "";
        conditions_string += data.hypothyroid ? "hypothyroid," : "";
        conditions_string += data.chf ? "chf," : "";
        conditions_string += data.msm ? "msm," : "";

        payload["conditions"] = conditions_string.slice(0, -1);
      }

      this.do_request(payload);
    }
  }
};
</script>

<style>
</style>