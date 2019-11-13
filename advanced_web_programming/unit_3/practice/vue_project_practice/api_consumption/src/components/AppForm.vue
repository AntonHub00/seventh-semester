<template>
  <div>
    <form @submit="sentData">
      <div class="form-row">
        <!-- all or vaccinations -->
        <div class="form-group col">
          <label for="recommendations">Recommendations</label>
          <select id="recommendations" class="form-control" v-model="recommendations" required>
            <option value="all">All</option>
            <option value="vac">Vaccinations</option>
          </select>
        </div>

        <!-- sex -->
        <div class="form-group col">
          <label for="sex">Sex</label>
          <select
            id="sex"
            class="form-control"
            v-model="sex"
            @change="pregnant = sex === 'm'?'':pregnant;
            postmenopause = sex === 'm'?false:postmenopause;
            msm = sex === 'f'?false:msm"
            required
          >
            <option value="m">Male</option>
            <option value="f">Female</option>
          </select>
        </div>

        <!-- pregnant -->
        <div class="form-group col" v-if="sex === 'f'">
          <label for="pregnant">Pregnant</label>
          <input
            type="number"
            step="any"
            class="form-control"
            id="pregnant"
            placeholder="weeks (optional)"
            v-model="pregnant"
          />
        </div>

        <!-- ethnicity -->
        <div class="form-group col">
          <label for="ethnicity">Ethnicity</label>
          <select id="ethnicity" class="form-control" v-model="ethnicity" required>
            <option value="aa">African american</option>
            <option value="hispanic">Hispanic</option>
            <option value="white">White</option>
          </select>
        </div>
      </div>

      <div class="form-row">
        <!-- age or birth -->
        <div
          class="form-group col"
          @change="age = ageOrBirthdayPicked === 'birthday'?'':age;
          dob = ageOrBirthdayPicked === 'age'?'':dob"
        >
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="ageRadio"
              name="ageOrBirthdayPicked"
              value="age"
              v-model="ageOrBirthdayPicked"
              required
            />
            <label class="form-check-label" for="ageRadio">Age</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="birthdayRadio"
              name="ageOrBirthdayPicked"
              value="birthday"
              v-model="ageOrBirthdayPicked"
              required
            />
            <label class="form-check-label" for="birthdayRadio">Birthday</label>
          </div>
        </div>
      </div>

      <div class="form-row">
        <!-- age -->
        <div class="form-group col" v-if="ageOrBirthdayPicked === 'age'">
          <input
            type="number"
            class="form-control"
            id="age"
            v-model="age"
            placeholder="years"
            required
          />
        </div>

        <!-- birthday -->
        <div class="form-group col" v-if="ageOrBirthdayPicked === 'birthday'">
          <input type="date" class="form-control" id="birthday" v-model="dob" required />
        </div>
      </div>

      <!-- smokerPicked -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="smokerPicked"
            name="smokerPicked"
            v-model="smokerPicked"
            @change="ppd = !smokerPicked?'':ppd;
            years_smoking = !smokerPicked?'':years_smoking"
          />
          <label class="form-check-label" for="smokerPicked">Smoker</label>
        </div>
      </div>

      <div class="form-row">
        <!-- packs per dar -->
        <div class="form-group col" v-if="smokerPicked">
          <label for="packsPerDay">Packs per day</label>
          <input
            type="number"
            step="any"
            class="form-control"
            id="packsPerDay"
            v-model="ppd"
            required
          />
        </div>

        <!-- years smoking -->
        <div class="form-group col" v-if="smokerPicked">
          <label for="yearsSmoking">Years smoking</label>
          <input
            type="number"
            step="any"
            class="form-control"
            id="yearsSmoking"
            v-model="years_smoking"
            required
          />
        </div>
      </div>

      <!-- body mass index -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="bodyMassIndexPicked"
            name="bodyMassIndexPicked"
            v-model="bodyMassIndexPicked"
          />
          <label class="form-check-label" for="bodyMassIndexPicked">Body Mass Index</label>
        </div>
      </div>

      <div class="form-row" v-if="bodyMassIndexPicked">
        <!-- bmi or calculate -->
        <div
          class="form-group col"
          @change="bmi = bmiOrCalculatePicked === 'calculateBmi'?'':bmi
          kg = bmiOrCalculatePicked === 'bmi'?'':kg;
          m = bmiOrCalculatePicked === 'bmi'?'':m;
          lbs = bmiOrCalculatePicked === 'bmi'?'':lbs;
          inches = bmiOrCalculatePicked === 'bmi'?'':inches;"
        >
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="bmiRadio"
              name="bmiOrCalculatePicked"
              value="bmi"
              v-model="bmiOrCalculatePicked"
              required
            />
            <label class="form-check-label" for="bmiRadio">BMI</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="calculateBmiRadio"
              name="bmiOrCalculatePicked"
              value="calculateBmi"
              v-model="bmiOrCalculatePicked"
              required
            />
            <label class="form-check-label" for="calculateBmiRadio">Calculate BMI</label>
          </div>
        </div>
      </div>

      <div class="form-row">
        <!-- bmi -->
        <div class="form-group col" v-if="bodyMassIndexPicked && bmiOrCalculatePicked === 'bmi'">
          <input type="number" step="any" class="form-control" id="bmi" v-model="bmi" required />
        </div>

        <!-- calculate bmi -->
        <div
          class="form-group col"
          v-if="bodyMassIndexPicked && bmiOrCalculatePicked === 'calculateBmi'"
          @change="kg = unitsSystem === 'es'?'':kg;
          m = unitsSystem === 'es'?'':m;
          lbs = unitsSystem === 'is'?'':lbs;
          inches = unitsSystem === 'is'?'':inches;"
        >
          <div class="row">
            <div class="col">
              <label for="unitsSystem">Units</label>
              <select id="unitsSystem" class="form-control" v-model="unitsSystem" required>
                <option value="is">International system</option>
                <option value="es">English system</option>
              </select>
            </div>
          </div>
        </div>

        <!-- units system -->
        <div
          class="form-group col"
          v-if="bodyMassIndexPicked &&  bmiOrCalculatePicked === 'calculateBmi'"
        >
          <!-- international system -->
          <div class="row" v-if="unitsSystem === 'is'">
            <div class="col">
              <label class for="kg">Kilograms</label>
              <input type="number" step="any" class="form-control" id="kg" v-model="kg" required />
            </div>
            <div class="col">
              <label for="m">Meters</label>
              <input type="number" step="any" class="form-control" id="m" v-model="m" required />
            </div>
          </div>

          <!-- english system -->
          <div class="row" v-if="unitsSystem === 'es'">
            <div class="col">
              <label class for="lbs">Pounds</label>
              <input type="number" step="any" class="form-control" id="lbs" v-model="lbs" required />
            </div>
            <div class="col">
              <label for="inches">Inches</label>
              <input
                type="number"
                step="any"
                class="form-control"
                id="inches"
                v-model="inches"
                required
              />
            </div>
          </div>
        </div>
      </div>

      <!-- tuberculosis skin test checkbox -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="tstPicked"
            name="tstPicked"
            v-model="tstPicked"
            @change="tst = tstPicked?tst:''"
          />
          <label class="form-check-label" for="tstPicked">Tuberculosis skin test</label>
        </div>
      </div>

      <div class="form-row">
        <!-- tuberculosis skin test value -->
        <div class="form-group col" v-if="tstPicked">
          <input
            type="number"
            step="any"
            class="form-control"
            id="tst"
            v-model="tst"
            placeholder="milimiters of induration"
            required
          />
        </div>
      </div>

      <!-- systolic blood pressure checkbox -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="sbpPicked"
            name="sbpPicked"
            v-model="sbpPicked"
            @change="sbp = sbpPicked?sbp:''"
          />
          <label class="form-check-label" for="sbpPicked">Systolic blood pressure</label>
        </div>
      </div>

      <div class="form-row">
        <!-- systolic blood pressure value -->
        <div class="form-group col" v-if="sbpPicked">
          <input type="number" class="form-control" id="sbp" v-model="sbp" required />
        </div>
      </div>

      <!-- diastolic blood pressure checkbox -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="dbpPicked"
            name="dbpPicked"
            v-model="dbpPicked"
            @change="dbp = dbpPicked?dbp:''"
          />
          <label class="form-check-label" for="dbpPicked">Diastolic blood pressure</label>
        </div>
      </div>

      <div class="form-row">
        <!-- diastolic blood pressure value -->
        <div class="form-group col" v-if="dbpPicked">
          <input type="number" class="form-control" id="dbp" v-model="dbp" required />
        </div>
      </div>

      <!-- low-density lipoprotein checkbox -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="ldlPicked"
            name="ldlPicked"
            v-model="ldlPicked"
            @change="ldl = ldlPicked?ldl:''"
          />
          <label class="form-check-label" for="ldlPicked">Low-density lipoprotein (LDL)</label>
        </div>
      </div>

      <div class="form-row">
        <!-- low-density lipoprotein value -->
        <div class="form-group col" v-if="ldlPicked">
          <input type="number" step="any" class="form-control" id="ldl" v-model="ldl" required />
        </div>
      </div>

      <!-- triglycerides checkbox -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="trigsPicked"
            name="trigsPicked"
            v-model="trigsPicked"
            @change="trigs = trigsPicked?trigs:''"
          />
          <label class="form-check-label" for="trigsPicked">Triglycerides</label>
        </div>
      </div>

      <div class="form-row">
        <!-- triglycerides value -->
        <div class="form-group col" v-if="trigsPicked">
          <input type="number" step="any" class="form-control" id="trigs" v-model="trigs" required />
        </div>
      </div>

      <!-- coronary artery calsium checkbox -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="cacPicked"
            name="cacPicked"
            v-model="cacPicked"
            @change="cac = cacPicked?cac:''"
          />
          <label class="form-check-label" for="cacPicked">Coronary artery calsium</label>
        </div>
      </div>

      <div class="form-row">
        <!-- coronary artery calsium value -->
        <div class="form-group col" v-if="cacPicked">
          <input type="number" step="any" class="form-control" id="cac" v-model="cac" required />
        </div>
      </div>

      <!-- conditions checkbox -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="conditionsPicked"
            name="conditionsPicked"
            v-model="conditionsPicked"
          />
          <label class="form-check-label" for="conditionsPicked">Conditions</label>
        </div>
      </div>

      <!-- first row -->
      <div class="form-row">
        <!-- diabetes checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="dm" name="dm" v-model="dm" />
            <label class="form-check-label" for="dm">Diabetes</label>
          </div>
        </div>

        <!-- overweight or obesity checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="obese" name="obese" v-model="obese" />
            <label class="form-check-label" for="obese">Overweight or Obesity</label>
          </div>
        </div>

        <!-- hiv checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="hiv" name="hiv" v-model="hiv" />
            <label class="form-check-label" for="hiv">HIV</label>
          </div>
        </div>

        <!-- sexually transmitted infection checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="sti" name="sti" v-model="sti" />
            <label class="form-check-label" for="sti">Sexually transmitted infection</label>
          </div>
        </div>

        <!-- postmenopause checkbox -->
        <div class="form-group col" v-if="conditionsPicked && sex === 'f'">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="postmenopause"
              name="postmenopause"
              v-model="postmenopause"
            />
            <label class="form-check-label" for="postmenopause">Postmenopause</label>
          </div>
        </div>
      </div>

      <!-- second row -->
      <div class="form-row">
        <!-- intravenous drug abuse checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="ivda" name="ivda" v-model="ivda" />
            <label class="form-check-label" for="ivda">Intravenous drug abuse</label>
          </div>
        </div>

        <!-- congestive Heart Failure checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="chf" name="chf" v-model="chf" />
            <label class="form-check-label" for="chf">Congestive Heart Failure</label>
          </div>
        </div>

        <!-- healthcare-associated checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="hca" name="hca" v-model="hca" />
            <label class="form-check-label" for="hca">Healthcare-associated</label>
          </div>
        </div>

        <!-- liver disease checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="liver" name="liver" v-model="liver" />
            <label class="form-check-label" for="liver">Liver disease</label>
          </div>
        </div>

        <!-- incarceration history checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="prison"
              name="prison"
              v-model="prison"
            />
            <label class="form-check-label" for="prison">Incarceration history</label>
          </div>
        </div>
      </div>

      <!-- third row -->
      <div class="form-row">
        <!-- dialysis (any type) checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="dialysis"
              name="dialysis"
              v-model="dialysis"
            />
            <label class="form-check-label" for="dialysis">Dialysis (any type)</label>
          </div>
        </div>

        <!-- functional or anatomic asplenia checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="asplenia"
              name="asplenia"
              v-model="asplenia"
            />
            <label class="form-check-label" for="asplenia">Functional or anatomic asplenia</label>
          </div>
        </div>

        <!-- sickle cell disease or trait checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="scd" name="scd" v-model="scd" />
            <label class="form-check-label" for="scd">Sickle cell disease or trait</label>
          </div>
        </div>

        <!-- hypertension checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="htn" name="htn" v-model="htn" />
            <label class="form-check-label" for="htn">Hypertension</label>
          </div>
        </div>

        <!-- chronic heart disease checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="heart" name="heart" v-model="heart" />
            <label class="form-check-label" for="heart">Chronic heart disease</label>
          </div>
        </div>
      </div>

      <!-- fourth row -->
      <div class="form-row">
        <!-- chronic lung disease checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="lung" name="lung" v-model="lung" />
            <label class="form-check-label" for="lung">Chronic lung disease</label>
          </div>
        </div>

        <!-- cerebrospinal fluid leak checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="csf" name="csf" v-model="csf" />
            <label class="form-check-label" for="csf">Cerebrospinal fluid leak</label>
          </div>
        </div>

        <!-- cochlear implant checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="cochlear"
              name="cochlear"
              v-model="cochlear"
            />
            <label class="form-check-label" for="cochlear">Cochlear implant</label>
          </div>
        </div>

        <!-- chronic kidney disease checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="ckd" name="ckd" v-model="ckd" />
            <label class="form-check-label" for="ckd">Chronic kidney disease</label>
          </div>
        </div>

        <!-- cancer / malignancy checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="ca" name="ca" v-model="ca" />
            <label class="form-check-label" for="ca">Cancer / malignancy</label>
          </div>
        </div>
      </div>

      <!-- fiveth row -->
      <div class="form-row">
        <!-- smoking status checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="smoker"
              name="smoker"
              v-model="smoker"
            />
            <label class="form-check-label" for="smoker">Smoking status</label>
          </div>
        </div>

        <!-- alcohol abuse checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="alcohol"
              name="alcohol"
              v-model="alcohol"
            />
            <label class="form-check-label" for="alcohol">Alcohol abuse</label>
          </div>
        </div>

        <!-- transplant status checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="transplant"
              name="transplant"
              v-model="transplant"
            />
            <label class="form-check-label" for="transplant">Transplant status</label>
          </div>
        </div>

        <!-- hypothyroidism checkbox -->
        <div class="form-group col" v-if="conditionsPicked">
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="checkbox"
              id="hypothyroid"
              name="hypothyroid"
              v-model="hypothyroid"
            />
            <label class="form-check-label" for="hypothyroid">Hypothyroidism</label>
          </div>
        </div>

        <!-- men who have sex with men checkbox -->
        <div class="form-group col" v-if="conditionsPicked && sex === 'm'">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="msm" name="msm" v-model="msm" />
            <label class="form-check-label" for="msm">Men who have sex with men</label>
          </div>
        </div>

      </div>

      <!-- submit -->
      <div class="form-group">
        <button type="submit" class="btn btn-primary">Get recommendation</button>
      </div>
    </form>

    <div>
      <p>Test area</p>
      <hr />

      <p>Request data</p>

      <hr />

      <p>recommendations: {{ recommendations }}</p>
      <p>
        sex: {{ sex }}
        || pregnant: {{ pregnant }}
        || ethnicity: {{ ethnicity }}
        || age: {{ age }}
        || dob: {{ dob }}
        || ppd: {{ ppd }}
        || years_smoking: {{ years_smoking }}
        || bmi: {{ bmi }}
        || kg: {{ kg }}
        || m: {{ m }}
        || lbs: {{ lbs }}
        || inches: {{ inches }}
        || tst: {{ tst }}
        || sbp: {{ sbp }}
        || dbp: {{ dbp }}
        || ldl: {{ ldl }}
        || trigs: {{ trigs }}
        || cac: {{ cac }}
        || dm: {{ dm }}
        || obese: {{ obese }}
        || hiv: {{ hiv }}
        || sti: {{ sti }}
        || postmenopause: {{ postmenopause }}
        || ivda: {{ ivda }}
        || msm: {{ msm }}
        || hca: {{ hca }}
        || liver: {{ liver }}
        || prison: {{ prison }}
        || dialysis: {{ dialysis }}
        || asplenia: {{ asplenia }}
        || scd: {{ scd }}
        || htn: {{ htn }}
        || heart: {{ heart }}
        || lung: {{ lung }}
        || csf: {{ csf }}
        || cochlear: {{ cochlear }}
        || ckd: {{ ckd }}
        || ca: {{ ca }}
        || smoker: {{ smoker }}
        || alcohol: {{ alcohol }}
        || transplant: {{ transplant }}
        || hypothyroid: {{ hypothyroid }}
        || chf: {{ chf }}
      </p>

      <hr />

      <p>Form control specific</p>

      <hr />

      <p>
        ageOrBirthdayPicked: {{ ageOrBirthdayPicked }}
        || smokerPicked: {{ smokerPicked }}
        || bodyMassIndexPicked: {{ bodyMassIndexPicked }}
        || bmiOrCalculatePicked: {{ bmiOrCalculatePicked }}
        || unitsSystem: {{ unitsSystem }}
        || tstPicked: {{ tstPicked }}
        || sbpPicked: {{ sbpPicked }}
        || dbpPicked: {{ dbpPicked }}
        || ldlPicked: {{ ldlPicked }}
        || trigsPicked: {{ trigsPicked }}
        || cacPicked: {{ cacPicked }}
        || conditionsPicked: {{ conditionsPicked }}
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppForm",
  data() {
    return {
      // request data
      recommendations: "all",
      sex: "m",
      pregnant: "",
      ethnicity: "aa",
      age: "",
      dob: "",
      ppd: "",
      years_smoking: "",
      bmi: "",
      kg: "",
      m: "",
      lbs: "",
      inches: "",
      tst: "",
      sbp: "",
      dbp: "",
      ldl: "",
      trigs: "",
      cac: "",

      //conditions
      dm: false,
      obese: false,
      hiv: false,
      sti: false,
      postmenopause: false,
      ivda: false,
      msm: false,
      hca: false,
      liver: false,
      prison: false,
      dialysis: false,
      asplenia: false,
      scd: false,
      htn: false,
      heart: false,
      lung: false,
      csf: false,
      cochlear: false,
      ckd: false,
      ca: false,
      smoker: false,
      alcohol: false,
      transplant: false,
      hypothyroid: false,
      chf: false,

      //form control specific
      ageOrBirthdayPicked: "age",
      smokerPicked: false,
      bodyMassIndexPicked: false,
      bmiOrCalculatePicked: "bmi",
      unitsSystem: "is",
      tstPicked: false,
      sbpPicked: false,
      dbpPicked: false,
      ldlPicked: false,
      trigsPicked: false,
      cacPicked: false,
      conditionsPicked: false,
    };
  },
  methods: {
    sentData(e){
      e.preventDefault();
      this.$emit('receive-data', this)
    }
  }
};
</script>

<style scoped>
</style>