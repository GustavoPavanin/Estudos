import ShortnerModel from "../model/ShortnerModel.js";
import crypto from 'crypto';
import userAgent from 'user-agents'
class ShortnerController {

  async getOne(request, response) {
    const id = request.params.id;
    try{
        const shortner = await ShortnerModel.findById(id);
        if (shortner) {
          response.send({shortner});
        } else {
          response.status(404).send({ message: "Shortner not exists" });
        }
    } catch(error){
        console.long(error);

        response.status(404).send({ message: "An unexpected error happened" });
    }
    
  }

  async index(request, response) {
    const shortner = await ShortnerModel.find();
    response.send({shortner});
  }

  async remove(request, response) {
    const id = request.params.id;
    try{
        const shortner = await ShortnerModel.findById(id);
        if (!shortner) {
          response.status(404).send({ message: "Shortner not exists" });
        }
        await shortner.remove();
        response.send({ message: "Shortner removed" });
    } catch(error){
        console.long(error);
        response.status(404).send({ message: "An unexpected error happened" });
    }
  }

  async store(request, response) {
    const { link = '' } = request.body;
    const [hash] = crypto.randomUUID().split('-');

    if(!link.trim()){
        return response.status(400).send({ message: "Link is missing"});
    }
    console.log("teste");
    const shortner = await ShortnerModel.create({
      link,
      hash: hash,
      ownerId: request.loggedUser.id,
    });

    response.send({ message: "Shortner created!", shortner });
    
  }
  
  async update(request, response) {
    // verificar se o shortner existe
    
        const { link } = request.body;
        const { id } = request.params;
        try{
                const shortner = await ShortnerModel.findByIdAndUpdate(id, { link });

                response.json(shortner)
        } catch(error){
            console.long(error);
            response.status(404).send({ message: "An unexpected error happened" });
        }
            
    //response.json({ message: "Ok!" });
  }

  static async redirect(request, response) {
    const {hash} = request.params;

    const shortner = await ShortnerModel.findOne({ hash });

    if (!shortner) {
        return response.redirect("/")
    }

    const userAgentData = userAgent(request.headers['user-agents'])

    const metadata = {
      ip: request.ip,
      parser: parser(request.headers['user-agents']),
    }

    shortner.hits += 1;
    shortner.metadata = [...shortner.metadata, metadata]
    await shortner.save();

    response.redirect(shortner.link);
  }
}

export default ShortnerController;
