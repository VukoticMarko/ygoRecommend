import React from "react";

export default function ExtraDeckCheckbox(){ 
  
  const [cedm, setValueTypes] = React.useState(0) 
  const handleChangeType = () => {
    setValueTypes(!cedm);
  };
  
    return (
      <div>
        <hr></hr>
        Choose Prefered Extra-Deck Mechanics <br></br>
        <input
            id="normal"
            type="checkbox"
            value="Fusion"
            checked={cedm}
            onChange={handleChangeType}
          />
          Fusion
          <input
            id="normal"
            type="checkbox"
            value="Synchro"
            checked={cedm}
            onChange={handleChangeType}
          />
          Sybchro
          <input
            id="normal"
            type="checkbox"
            value="XYZ"
            checked={cedm}
            onChange={handleChangeType}
          />
          XYZ
          <input
            id="normal"
            type="checkbox"
            value="Link"
            checked={cedm}
            onChange={handleChangeType}
          />
          Link
          
      </div>
     
    );
  
}