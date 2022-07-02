import React, { useState } from "react";
import "rsuite/dist/rsuite.min.css";
import { InputNumber } from "rsuite";
import TypeCheckbox from "../checkbox/type-checkbox";
import SubTypeCheckBox from "../checkbox/sub-type-checkbox";
import ExtraDeckCheckbox from "../checkbox/extra-deck-checkbox";
import PlaystyleCheckbox from "../checkbox/playstyle-checkbox";
import { Button } from "react-bootstrap";
import RecommendService from "./recommendService";
import { useEffect } from "react";
import axios from "axios";

export default function Recommend() {
  const [numberOfDecks, setValueNumberDecks] = React.useState(0);
  const [chosenDifficulty, setValueDifficulty] = React.useState(0);
  const [scoredList, setScoredList] = React.useState([]);
  const [dataa, setDataa] = useState([]);


  //var scoredList = [];
  var chosenTypes = [];
  const handleChangeType = (value) => {
    console.log(value);
    chosenTypes.push(value);
  };
  var chosenSubTypes = [];
  const handleChangeSubType = (value) => {
    chosenSubTypes.push(value);
  };
  var chosenExtraDeckMechanics = [];
  const handleChangeExtra = (value) => {
    chosenExtraDeckMechanics.push(value);
  };
  var chosenPlaystyles = [];
  const handleChangePlaystyle = (value) => {
    chosenPlaystyles.push(value);
  };


  var [ArchetypeRequest, serAreq] = useState({
    chosenTypes: chosenTypes,
    chosenDifficulty: 1,
    chosenSubTypes: chosenSubTypes,
    chosenPlaystyles: chosenPlaystyles,
    chosenExtraDeckMechanics: chosenExtraDeckMechanics,
    numberOfDecks: 1,
  });

  const handleClick = (e) => {
    e.preventDefault();
    console.log(chosenTypes)
    ArchetypeRequest = {
      chosenTypes: chosenTypes,
      chosenDifficulty: chosenDifficulty,
      chosenSubTypes: chosenSubTypes,
      chosenPlaystyles: chosenPlaystyles,
      chosenExtraDeckMechanics: chosenExtraDeckMechanics,
      numberOfDecks: numberOfDecks,
    };
    if (ArchetypeRequest.numberOfDecks === 0) {
      ArchetypeRequest.numberOfDecks = 1;
    }
    if (ArchetypeRequest.chosenDifficulty === 0) {
      ArchetypeRequest.chosenDifficulty = 1;
    }

    axios
      .post("http://localhost:8080/api/archetypes/recommend", ArchetypeRequest)
      .then((response) => {
        setDataa(response.data);
        document.querySelectorAll('input[type="checkbox"]')
       .forEach(el => el.checked = false);
      });
  };


  var res = [];
  // useEffect(() => {
  //     setScoredList(res);
  // }, []);

  async function recommend() {
    ArchetypeRequest = {
      chosenTypes: chosenTypes,
      chosenDifficulty: chosenDifficulty,
      chosenSubTypes: chosenSubTypes,
      chosenPlaystyles: chosenPlaystyles,
      chosenExtraDeckMechanics: chosenExtraDeckMechanics,
      numberOfDecks: numberOfDecks,
    };
    if (ArchetypeRequest.numberOfDecks === 0) {
      ArchetypeRequest.numberOfDecks = 1;
    }
    if (ArchetypeRequest.chosenDifficulty === 0) {
      ArchetypeRequest.chosenDifficulty = 1;
    }
    console.log(ArchetypeRequest);
    res = await RecommendService.recommend(ArchetypeRequest);
    // setScoredList(res);
    console.log(res);
  }

  const printList = dataa.map((resp) => {
    return (
      <tr key={resp.id}>
        <td>{resp.archetypeName}</td>
        <td>{resp.currentScore}</td>
        <td>
          <div className="desc">{resp.description}</div>
        </td>
        <td></td>
      </tr>
    );
  });

  return (
    <div id="main">
      <form>
        <div id="input-number-decks">
          <InputNumber
            min={5}
            max={100}
            defaultValue={1}
            onChange={(value) => {
              setValueNumberDecks(value);
            }}
          />
          Number Of Decks Selected : {numberOfDecks}
        </div>
        <div id="input-difficulty">
          <InputNumber
            min={1}
            max={12}
            defaultValue={1}
            onChange={(value) => {
              setValueDifficulty(value);
            }}
          />
          Selected Difficulty : {chosenDifficulty}
        </div>

        <div id="checkboxes-type">
          <hr></hr>
          Choose Prefered Types <br></br>
          <div className="input-container">
            <div className="checkbox-container">
              <input
                id="aqua"
                type="checkbox"
                value="Aqua"
                onChange={() => handleChangeType("Aqua")}
              />
              Aqua
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Beast"
                onChange={() => handleChangeType("Beast")}
              />
              Beast
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Beast_Warrior"
                onChange={() => handleChangeType("Beast_Warrior")}
              />
              Beast_Warrior
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Cyberse"
                onChange={() => handleChangeType("Cyberse")}
              />
              Cyberse
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Dinosaur"
                onChange={() => handleChangeType("Dinosaur")}
              />
              Dinosaur
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Divine_Beast"
                onChange={() => handleChangeType("Divine_Beast")}
              />
              Divine_Beast
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Dragon"
                onChange={() => handleChangeType("Dragon")}
              />
              Dragon
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Fairy"
                onChange={() => handleChangeType("Fairy")}
              />
              Fairy
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Fiend"
                onChange={() => handleChangeType("Fiend")}
              />
              Fiend
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Fish"
                onChange={() => handleChangeType("Fish")}
              />
              Fish
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Insect"
                onChange={() => handleChangeType("Insect")}
              />
              Insect
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Machine"
                onChange={() => handleChangeType("Machine")}
              />
              Machine
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Plant"
                onChange={() => handleChangeType("Plant")}
              />
              Plant
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Psychic"
                onChange={() => handleChangeType("Psychic")}
              />
              Psychic
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Pyro"
                onChange={() => handleChangeType("Pyro")}
              />
              Pyro
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Reptile"
                onChange={() => handleChangeType("Reptile")}
              />
              Reptile
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Rock"
                onChange={() => handleChangeType("Rock")}
              />
              Rock
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Sea_Serpent"
                onChange={() => handleChangeType("Sea_Serpent")}
              />
              Sea_Serpent
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Spellcaster"
                onChange={() => handleChangeType("Spellcaster")}
              />
              Spellcaster
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Thunder"
                onChange={() => handleChangeType("Thunder")}
              />
              Thunder
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Warrior"
                onChange={() => handleChangeType("Warrior")}
              />
              Warrior
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Winged_Beast"
                onChange={() => handleChangeType("Winged_Beast")}
              />
              Winged_Beast
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Wyrm"
                onChange={() => handleChangeType("Wrym")}
              />
              Wyrm
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Zombie"
                onChange={() => handleChangeType("Zombie")}
              />
              Zombie
            </div>
          </div>
        </div>
        <div id="checkboxes-subtype">
          <hr></hr>
          Choose Prefered Sub-Types <br></br>
          <div className="input-container">
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Normal"
                onChange={() => handleChangeSubType("Normal")}
              />
              Normal
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Effect"
                onChange={() => handleChangeSubType("Effect")}
              />
              Effect
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Fusion"
                onChange={() => handleChangeSubType("Fusion")}
              />
              Fusion
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Synchro"
                onChange={() => handleChangeSubType("Synchro")}
              />
              Synchro
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Pendulum"
                onChange={() => handleChangeSubType("Pendulum")}
              />
              Pendulum
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="XYZ"
                onChange={() => handleChangeSubType("XYZ")}
              />
              XYZ
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Link"
                onChange={() => handleChangeSubType("Link")}
              />
              Link
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Token"
                onChange={() => handleChangeSubType("Token")}
              />
              Token
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Tuner"
                onChange={() => handleChangeSubType("Tuner")}
              />
              Tuner
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Ritual"
                onChange={() => handleChangeSubType("Ritual")}
              />
              Ritual
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Toon"
                onChange={() => handleChangeSubType("Toon")}
              />
              Toon
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Union"
                onChange={() => handleChangeSubType("Union")}
              />
              Union
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Spirit"
                onChange={() => handleChangeSubType("Spirit")}
              />
              Spirit
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Gemini"
                onChange={() => handleChangeSubType("Gemini")}
              />
              Gemini
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Flip"
                onChange={() => handleChangeSubType("Flip")}
              />
              Flip
            </div>
          </div>
        </div>
        <div id="checkboxes-extradeck">
          <hr></hr>
          Choose Prefered Extra-Deck Mechanics <br></br>
          <div className="input-container">
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Fusion"
                onChange={() => handleChangeExtra("Fusion")}
              />
              Fusion
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Synchro"
                onChange={() => handleChangeExtra("Synchro")}
              />
              Synchro
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="XYZ"
                onChange={() => handleChangeExtra("XYZ")}
              />
              XYZ
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Link"
                onChange={() => handleChangeExtra("Link")}
              />
              Link
            </div>
          </div>
        </div>
        <div id="checkboxes-subtype">
          <hr></hr>
          Choose Prefered Playstyle <br></br>
          <div className="input-container">
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Beatdown_Aggro"
                onChange={() => handleChangePlaystyle("Beatdown_Aggro")}
              />
              Beatdown_Aggro
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="OTK"
                onChange={() => handleChangePlaystyle("OTK")}
              />
              OTK
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Control"
                onChange={() => handleChangePlaystyle("Control")}
              />
              Control
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Lock"
                onChange={() => handleChangePlaystyle("Lock")}
              />
              Lock
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Burn"
                onChange={() => handleChangePlaystyle("Burn")}
              />
              Burn
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Combo"
                onChange={() => handleChangePlaystyle("Combo")}
              />
              Combo
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Stun"
                onChange={() => handleChangePlaystyle("Stun")}
              />
              Stun
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Backrow_Defense"
                onChange={() => handleChangePlaystyle("Backrow_Defense")}
              />
              Backrow_Defense
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="FTK"
                onChange={() => handleChangePlaystyle("FTK")}
              />
              FTK
            </div>
            <div className="checkbox-container">
              <input
                id="normal"
                type="checkbox"
                value="Mill"
                onChange={() => handleChangePlaystyle("Mill")}
              />
              Mill
            </div>
          </div>
        </div>
        <div id="button">
          <br></br>
          <Button onClick={handleClick}>GO!</Button>
        </div>
        <div>
          Recommendation:
          <div className="container-table">
            <table className="decks-table">
              <thead>
                <tr>
                  <th>Name</th>
                  <th>Score</th>
                  <th>Descritpion</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>{printList}</tbody>
            </table>
          </div>
        </div>
      </form>
    </div>
  );
}
