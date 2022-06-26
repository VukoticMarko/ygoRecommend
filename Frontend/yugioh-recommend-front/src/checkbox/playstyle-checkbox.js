import React from "react";

export default function PlaystyleCheckbox(){ 
  
  const [chosenExtraDeckMechanics, setValueTypes] = React.useState(0) 
  const handleChangeType = () => {
    setValueTypes(!chosenExtraDeckMechanics);
  };
  
    return (
      <div>
        <hr></hr>
        Choose Prefered Playstyle <br></br>
        <input
            id="normal"
            type="checkbox"
            value="Beatdown_Aggro"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Beatdown_Aggro
          <input
            id="normal"
            type="checkbox"
            value="OTK"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          OTK
          <input
            id="normal"
            type="checkbox"
            value="Control"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Control
          <input
            id="normal"
            type="checkbox"
            value="Lock"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Lock
          <input
            id="normal"
            type="checkbox"
            value="Burn"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Burn
          <input
            id="normal"
            type="checkbox"
            value="Combo"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Combo
          <input
            id="normal"
            type="checkbox"
            value="Stun"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Stun
          <input
            id="normal"
            type="checkbox"
            value="Backrow_Defense"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Backrow_Defense
          <input
            id="normal"
            type="checkbox"
            value="FTK"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          FTK
          <input
            id="normal"
            type="checkbox"
            value="Mill"
            checked={chosenExtraDeckMechanics}
            onChange={handleChangeType}
          />
          Mill
          
      </div>
     
    );
  
}