<template>
  <div>
    <form>
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
            @change="pregnant = sex === 'm'?'':pregnant"
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
          @change="age = ageOrBirthday === 'birthday'?'':age;
          dob = ageOrBirthday === 'age'?'':dob"
        >
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="ageRadio"
              name="ageOrBirthday"
              value="age"
              v-model="ageOrBirthday"
              required
            />
            <label class="form-check-label" for="ageRadio">Age</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="birthdayRadio"
              name="ageOrBirthday"
              value="birthday"
              v-model="ageOrBirthday"
              required
            />
            <label class="form-check-label" for="birthdayRadio">Birthday</label>
          </div>
        </div>
      </div>

      <div class="form-row">
        <!-- age -->
        <div class="form-group col" v-if="ageOrBirthday === 'age'">
          <label for="age">Age</label>
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
        <div class="form-group col" v-if="ageOrBirthday === 'birthday'">
          <label for="birthday">Birthday</label>
          <input type="date" class="form-control" id="birthday" v-model="dob" required />
        </div>
      </div>

      <!-- smoker -->
      <div class="form-group">
        <div class="form-check form-check-inline">
          <input
            class="form-check-input"
            type="checkbox"
            id="smoker"
            name="smoker"
            v-model="smoker"
            @change="ppd = !smoker?'':ppd;
            years_smoking = !smoker?'':years_smoking"
          />
          <label class="form-check-label" for="smoker">Smoker</label>
        </div>
      </div>

      <div class="form-row">
        <!-- packs per dar -->
        <div class="form-group col" v-if="smoker">
          <label for="packsPerDay">Packs per day</label>
          <input
            type="number"
            class="form-control"
            id="packsPerDay"
            v-model="ppd"
            placeholder="packs per day"
            required
          />
        </div>

        <!-- years smoking -->
        <div class="form-group col" v-if="smoker">
          <label for="yearsSmoking">Years smoking</label>
          <input
            type="number"
            class="form-control"
            id="yearsSmoking"
            v-model="years_smoking"
            placeholder="years smoking"
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
            id="bodyMassIndex"
            name="bodyMassIndex"
            v-model="bodyMassIndex"
          />
          <label class="form-check-label" for="bodyMassIndex">Body Mass Index</label>
        </div>
      </div>

      <div class="form-row" v-if="bodyMassIndex">
        <!-- bmi or calculate -->
        <div
          class="form-group col"
          @change="bmi = bmiOrCalculate === 'calculateBmi'?'':bmi
          kg = bmiOrCalculate === 'bmi'?'':kg;
          m = bmiOrCalculate === 'bmi'?'':m;
          lbs = bmiOrCalculate === 'bmi'?'':lbs;
          inches = bmiOrCalculate === 'bmi'?'':inches;"
        >
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="bmiRadio"
              name="bmiOrCalculate"
              value="bmi"
              v-model="bmiOrCalculate"
              required
            />
            <label class="form-check-label" for="bmiRadio">BMI</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              id="calculateBmiRadio"
              name="bmiOrCalculate"
              value="calculateBmi"
              v-model="bmiOrCalculate"
              required
            />
            <label class="form-check-label" for="calculateBmiRadio">Calculate BMI</label>
          </div>
        </div>
      </div>

      <div class="form-row">
        <!-- bmi -->
        <div class="form-group col" v-if="bodyMassIndex && bmiOrCalculate === 'bmi'">
          <label for="bmi">BMI</label>
          <input type="number" class="form-control" id="bmi" v-model="bmi" placeholder="body mass index" required />
        </div>

        <!-- calculate bmi -->
        <div
          class="form-group col"
          v-if="bodyMassIndex && bmiOrCalculate === 'calculateBmi'"
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
        <div class="form-group col" v-if="bodyMassIndex &&  bmiOrCalculate === 'calculateBmi'">
          <!-- international system -->
          <div class="row" v-if="unitsSystem === 'is'">
            <div class="col">
              <label class for="kg">Kilograms</label>
              <input type="number" class="form-control" id="kg" v-model="kg" placeholder="kilograms" required />
            </div>
            <div class="col">
              <label for="m">Meters</label>
              <input type="number" class="form-control" id="m" v-model="m" placeholder="meters" required />
            </div>
          </div>

          <!-- english system -->
          <div class="row" v-if="unitsSystem === 'es'">
            <div class="col">
              <label class for="lbs">Pounds</label>
              <input type="number" class="form-control" id="lbs" v-model="lbs" placeholder="pounds" required />
            </div>
            <div class="col">
              <label for="inches">Inches</label>
              <input type="number" class="form-control" id="inches" v-model="inches" placeholder="inches" required />
            </div>
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
      <p>sex: {{ sex }}</p>
      <p>pregnant: {{ pregnant }}</p>
      <p>ethnicity: {{ ethnicity }}</p>
      <p>age: {{ age }}</p>
      <p>dob: {{ dob }}</p>
      <p>ppd: {{ ppd }}</p>
      <p>years_smoking: {{ years_smoking }}</p>
      <p>bmi: {{ bmi }}</p>
      <p>kg: {{ kg }}</p>
      <p>m: {{ m }}</p>
      <p>lbs: {{ lbs }}</p>
      <p>inches: {{ inches }}</p>

      <hr />

      <p>Form control specific</p>

      <hr />

      <p>ageOrBirthday: {{ ageOrBirthday }}</p>
      <p>smoker: {{ smoker }}</p>
      <p>bodyMassIndex: {{ bodyMassIndex }}</p>
      <p>bmiOrCalculate: {{ bmiOrCalculate }}</p>
      <p>unitsSystem: {{ unitsSystem }}</p>
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

      //form control specific
      ageOrBirthday: "age",
      smoker: "",
      bodyMassIndex: "",
      bmiOrCalculate: "bmi",
      unitsSystem: "is"
    };
  }
};
</script>

<style scoped>
</style>