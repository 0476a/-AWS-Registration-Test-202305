import axios from "axios";
import { useState } from "react";
import { useMutation } from "react-query";

function App() {
  const [registrationData, setRegistrationData] = useState({
    username: "",
    password: "",
    email: "",
    name: "",
  });

  const registDataInputOnChangeHandle = (e) => {
    const { name, value } = e.target;
    setRegistrationData({ ...registrationData, [name]: value });
  }

  const registrationDataSubmit = useMutation(async () => {
    const data = {
      ...registrationData
    }
    const option = {
      headers: {
        "Content-Type": "application/json"
      }
    }
    try {
      await axios.post(`http://localhost:8080/auth/signup`, JSON.stringify(data), option);
      alert("회원가입 성공")
    } catch (error) {
      alert("회원가입 실패")
    }
  });

  const registrationOnSubmitHandle = () => {
    registrationDataSubmit.mutate();
  }

  return (
    <>
      <h1>회원가입</h1>
      <input type="text" placeholder="사용자이름" onChange={registDataInputOnChangeHandle} name="username" />
      <input type="text" placeholder="비밀번호" onChange={registDataInputOnChangeHandle} name="password" />
      <input type="text" placeholder="이메일" onChange={registDataInputOnChangeHandle} name="email" />
      <input type="text" placeholder="성명" onChange={registDataInputOnChangeHandle} name="name" />
      <button onClick={registrationOnSubmitHandle}>가입하기</button>
    </>
  );
}

export default App;
