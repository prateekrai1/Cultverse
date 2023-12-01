import Maincontent from "./Maincontent";
import Sidemenu from "./Sidemenu";
import "./home.css";

export default function Home() {
  return (
    <>
      <div className="container">
        <Sidemenu />
        <Maincontent />
      </div>
    </>
  );
}
